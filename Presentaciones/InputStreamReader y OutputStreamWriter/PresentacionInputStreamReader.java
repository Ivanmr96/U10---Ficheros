import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;

public class PresentacionInputStreamReader
{
	public static void main(String[] args)
	{
		InputStreamReader reader = null;			//declara el objeto que actuará como reader
		FileInputStream entradaFichero = null;		//declara el flujo de entrada para ficheros, que obtendrá bytes del fichero.
		File fichero = null;						//declara el objeto fichero.
		
		int caracter;
		
		try
		{
			fichero = new File("fichero.dat");					//Inicializa el objeto fichero, que tomará el path especificado
			entradaFichero = new FileInputStream(fichero);		//Inicializa el flujo de entrada del fichero, tomando el objeto tipo File

			reader = new InputStreamReader(entradaFichero, "ISO-8859-1");		//Inicializa el reader, que leerá del flujo inicializado arriba.
			
			//Métodos
			
			System.out.println("reader.ready(): " + reader.ready());

			System.out.println("--------------------------------------------------------------------");
			
			while(reader.ready())								//Se leerán caracteres y se imprimiran hasta encontrar el fin de fichero.
			{
				caracter = reader.read();
				System.out.print(caracter + " ");
			}
			
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			
			System.out.println("reader.ready(): " + reader.ready());
			
			System.out.println("--------------------------------------------------------------------");
			
		}														
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally	 //Se cierran el reader y el flujo de entrada.
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
		
		//Se necesita abrir de nuevo el fichero para poder leerlo de nuevo.
		try
		{
			fichero = new File("fichero.dat");					//Inicializa el objeto fichero, que tomará el path especificado
			entradaFichero = new FileInputStream(fichero);		//Inicializa el flujo de entrada del fichero, tomando el objeto tipo File
			
			reader = new InputStreamReader(entradaFichero, "ISO-8859-1");		//Inicializa el reader, que leerá del flujo inicializado arriba.
		
			while(reader.ready())								//Leerá los caracteres e imprimirá haciendo un cast a char.
			{
				caracter = reader.read();
				System.out.print((char)caracter);
			}
		}														
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally	 //Se cierran el reader y el flujo de entrada.
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
