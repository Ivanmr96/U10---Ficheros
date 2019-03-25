import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;

public class PresentacionInputStreamReader
{
	public static void main(String[] args)
	{
		InputStreamReader reader = null;			//declara el objeto que leerá
		FileInputStream entradaFichero = null;		//declara el flujo de entrada para ficheros
		FileInputStream entradaFichero2 = null;
		
		//Prueba de la clase tomando como entrada un fichero.	
		try
		{
			File fichero;						//declara el objeto del fichero
			
			fichero = new File("fichero.txt");					//Inicializa el objeto fichero, que tomará el path especificado
			entradaFichero = new FileInputStream(fichero);		//Inicializa el flujo de entrada del fichero, tomando el objeto tipo File
																//especificado ya.
																
			entradaFichero2 = new FileInputStream(fichero);
			
			reader = new InputStreamReader(entradaFichero);		//Inicializa el reader, que leerá del flujo inicializado arriba.
			
			//Métodos
			
			System.out.println("reader.ready(): " + reader.ready());

			System.out.println("--------------------------------------------------------------------");
			
			int caracter = reader.read();
			
			while(caracter != -1)								//Se leerán caracteres y se imprimiran hasta encontrar el fin de fichero.
			{
				System.out.print(caracter + " ");
				caracter = reader.read();
			}
			
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			
			reader = new InputStreamReader(entradaFichero2);	//Cambia el reader para que lea del otro flujo creado anteriormente
			
			caracter = reader.read();
			
			while(caracter != -1)								//Leerá los caracteres e imprimirá haciendo un cast a char.
			{
				System.out.print((char)caracter);
				caracter = reader.read();
			}
			
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			
			System.out.println("reader.ready(): " + reader.ready());
			
		}														
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally	 //Se cierran el reader y los flujos de entrada.
		{
			try
			{
				reader.close();
				entradaFichero.close();
				entradaFichero2.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
															
		
		
	}
}
