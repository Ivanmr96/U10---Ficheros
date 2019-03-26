import java.io.*;
import java.util.Scanner;

public class Writer
{
	
	/* INTERFAZ
	 * Comentario: Introduce un objeto en un fichero, sin sobreescribir lo que ya había en él.
	 * Prototipo: public void insertarObjeto(Object obj, String pathFichero)
	 * Entrada: un objeto a insertar y un String con el path del fichero en el que se insertará
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: El objeto queda insertado en el archivo determinado.
	 */
	public void insertarObjeto(Object obj, String pathFichero)
	{
		ObjectOutputStream writer = null;
		FileOutputStream salidaFichero = null;
		File fichero = null;
		
		try
		{
			fichero = new File(pathFichero);
			salidaFichero = new FileOutputStream(fichero, true);
			writer = new ObjectOutputStream(salidaFichero);
			OutputStreamWriter osw = new OutputStreamWriter(salidaFichero);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.append(" ");
			
			//writer.writeObject(obj);
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

}
