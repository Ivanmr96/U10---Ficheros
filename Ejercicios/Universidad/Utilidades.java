//package clases;

import java.io.*;

public class Utilidades 
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
	
	public void mostrarFicheroObjetos(String ruta)
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File(ruta);
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			
			Object obj = reader.readObject();
			while(obj != null)
			{
				System.out.println(obj.toString());
				obj = reader.readObject();
			}
		}
		catch(EOFException e)
		{
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
	}
}
