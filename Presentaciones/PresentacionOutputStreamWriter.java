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
			fichero = new File("fichero.txt");
			salidaFichero = new FileOutputStream(fichero);
			writer = new OutputStreamWriter(salidaFichero);
			
			//Métodos
			writer.write('A');
			
			writer.flush();		//Es importante usar este método para asegurar
								//que se escribe, aunque el método close() hace uso de flush y aquí no es necesario.
			
			writer.write('B');
			writer.write('C');
			
			writer.write("\nEsto es un salto de linea");
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
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
}
