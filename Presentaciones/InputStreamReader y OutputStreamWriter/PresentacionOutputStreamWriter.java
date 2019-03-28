import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class PresentacionOutputStreamWriter
{
	public static void main(String[] args)
	{
		OutputStreamWriter writer = null;
		FileOutputStream salidaFichero = null;
		File fichero = null;
		
		try
		{	
			fichero = new File("fichero.dat");
			salidaFichero = new FileOutputStream(fichero);
			writer = new OutputStreamWriter(salidaFichero, "ISO-8859-1");

			//Métodos
		
			writer.write(23); 	//el numero que representa el caracter dependerá del charset, por defecto ASCII.
			writer.write('A');
	
			writer.flush();		//Es importante usar este método para asegurar que se escribe.
			
			writer.write("\nhola");		//Método heredado de la clase Writer.
			
			writer.flush();	
			
			writer.write("\n¡Y puedo escribir acentos y caracteres españoles!\n");
			
			writer.flush();	
			
			char[] arrayChar = {'A', 'B', 'C', 'D', 'E', 'F'};		
			writer.write(arrayChar, 2, (arrayChar.length - 2));
			
			writer.flush();
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
