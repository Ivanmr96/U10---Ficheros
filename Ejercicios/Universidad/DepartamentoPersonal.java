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
		insertarObjeto(prof, "personal.txt");
	}
	
	public Profesor profesorMasJoven()
	{
		Profesor masJoven = new Profesor(0, " ", '-', 100);
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
				profesor = (Profesor)reader.readObject();
				
				if(profesor.getEdad() < masJoven.getEdad())
					masJoven = profesor;
			}
		}
		catch(EOFException e){}
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
	
	public Profesor profesorMayor()
	{
		Profesor mayor = new Profesor(0, " ", '-', 0);
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
				
				//System.out.println("PROFESOR LEIDO: " + profesor.getNombre());
				profesor = (Profesor)reader.readObject();
				if(profesor.getEdad() > mayor.getEdad())
					mayor = profesor;
			}
		}
		catch(EOFException e){}
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
		
		return mayor;
	}
	
	public void mostrarProfesores()
	{
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
				System.out.println(profesor.toString());
				System.out.println();
				profesor = (Profesor)reader.readObject();
			}
		}
		catch(EOFException e)
		{
		}
		catch(ClassNotFoundException e)
		{
			
		}
		catch(IOException e)
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
	}
	
	public double edadPromedio()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		int contadorProfesores = 0;
		double media;
		double acumuladorEdades = 0;
		
		try
		{
			fichero = new File("personal.txt");
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			
			Profesor profesor = (Profesor)reader.readObject();
			contadorProfesores++;
			acumuladorEdades += profesor.getEdad();
			while(profesor != null)
			{
				profesor = (Profesor)reader.readObject();
				contadorProfesores++;
				acumuladorEdades += profesor.getEdad();
			}
		}
		catch(EOFException e)
		{
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
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
		
		media = acumuladorEdades / contadorProfesores;
		
		return media;
	}
}
