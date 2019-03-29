import java.io.*;

public class DepartamentoPersonal
{
	/* INTERFAZ
	 * Comentario: inserta un objeto en un fichero especificado.
	 * Prototipo: public <T> void insertarObjeto(T obj, String ruta)
	 * Entrada: Un objeto serializable, y un String con la ruta del fichero
	 * Precondiciones: el objeto debe ser serializable
	 * Salida: No hay
	 * Postcondiciones: inserta un objeto en el fichero especificado, si el fichero no existe, lo crea.
	 */
	public <T> void insertarObjeto(T obj, String ruta)
	{
		File fichero = null;
		FileOutputStream salidaFichero = null;
		//ObjectWriter writer = null;
		ObjectOutputStream writer = null;
		boolean conCabecera = false;
		
		try
		{
			fichero = new File(ruta);
			
			if(fichero.length() > 0)
				conCabecera = false;
			else
				conCabecera = true;
				
			salidaFichero = new FileOutputStream(fichero, true);
			
			
			if(conCabecera == false)
				writer = new ObjectWriter(salidaFichero);
			else
				writer = new ObjectOutputStream(salidaFichero);
			
			writer.writeObject(obj);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				writer.close();
				salidaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	
	public void insertarProfesor(Profesor prof)
	{
		File fichero = null;
		FileOutputStream salidaFichero = null;
		ObjectWriter writer = null;
		ObjectOutputStream writerHeader = null;
		boolean conCabecera = false;
		
		try
		{
			fichero = new File("personal.txt");
			
			if(fichero.length() > 0)
				conCabecera = false;
			else
				conCabecera = true;
				
			salidaFichero = new FileOutputStream(fichero, true);
			
			
			if(conCabecera == false)
			{
				System.out.println("Escribiendo sin cabecera a " + prof.getNombre());
				writer = new ObjectWriter(salidaFichero);
				writer.writeObject(prof);
			}
			else
			{
				System.out.println("Escribiendo CON cabecera a " + prof.getNombre());
				writerHeader = new ObjectOutputStream(salidaFichero);
				writerHeader.writeObject(prof);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				if(conCabecera == false)
				{
					writer.close();
				}
				else
				{
					writerHeader.close();
				}
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	
	public Profesor profesorMasJoven()
	{
		Profesor masJoven = new Profesor(" ", '-', 100);
		int edad = 0;
		String nombre = " ";
		char sexo = ' ';
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File("personal.txt");
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			Profesor profesor = (Profesor)reader.readObject();
			while(profesor != null)
			{
				/*nombre = reader.readLine();
				System.out.println("nombre: " + nombre);
				sexo = reader.readChar();
				System.out.println("sexo: " + sexo);
				edad = reader.readInt();
				System.out.println("edad: " + edad);
				System.out.println();*/
				profesor = (Profesor)reader.readObject();
				
				System.out.println("PROFESOR LEIDO: " + profesor.getNombre());
				
				if(profesor.getEdad() < masJoven.getEdad())
					masJoven = profesor;
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				reader.close();
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return masJoven;
	}
}
