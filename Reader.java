import java.io.*;
import java.util.Scanner;

public class Reader
{
	/* INTERFAZ
	 * Comentario: Lee un objeto de un fichero.
	 * Prototipo: public Object leerObjeto(String pathFichero)
	 * Entrada: Un String con el path del fichero del que se leerá.
	 * Precondiciones: No hay
	 * Salida: Un Object
	 * Postcondiciones: Asociado al nombre devuelve el objeto leido.
	 */
	 
	public Object leerObjeto(String pathFichero)
	{
		File archivo = null;
		ObjectInputStream reader = null;
		FileInputStream entradaFichero = null;
		
		Object obj = null;
		
		try
		{
			archivo = new File(pathFichero);
			entradaFichero = new FileInputStream(archivo);
			reader = new ObjectInputStream(entradaFichero);
			
			obj = reader.readObject();
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
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return obj;
	}
}
