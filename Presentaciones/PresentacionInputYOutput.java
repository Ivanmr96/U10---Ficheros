import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;

import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

import java.util.Scanner;



public class PresentacionInputYOutput
{
	public static void main(String[] args)
	{
		File ficheroOrigen = null;
		File ficheroDestino = null;
		
		FileInputStream entradaArchivoOrigen = null;
		FileOutputStream salidaArchivoDestino = null;
	
		InputStreamReader reader = null;
		OutputStreamWriter writer = null;
		
		char[] array = null;
		
		//Leemos el fichero de origen y lo guardamos en memoria
		try
		{
			ficheroOrigen = new File("ficheroOrigen.txt");
			entradaArchivoOrigen = new FileInputStream(ficheroOrigen);
			reader = new InputStreamReader(entradaArchivoOrigen);
			
			int tamanhoFichero = (int)ficheroOrigen.length();
			
			array = new char[tamanhoFichero];
			
			reader.read(array);
			
			System.out.println("ARCHIVO COPIADO EN MEMORIA");
			
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
				entradaArchivoOrigen.close();
				
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		System.out.println();
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Contenido del archivo copiado en memoria:");
		System.out.println();
		for(int i = 0 ; i < array.length ; i++)
		{
			System.out.print(array[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		
		//Escribe en el fichero de destino el array guardado en memoria, que contiene el texto del fichero de origen ya leido.
		try
		{
			ficheroDestino = new File("ficheroDestino.txt");
			salidaArchivoDestino = new FileOutputStream(ficheroDestino);
			writer = new OutputStreamWriter(salidaArchivoDestino);
			
			writer.write(array);
			
			writer.flush();			//No es necesario ya que el close() en el finally lo usa.
			
			System.out.println();
			System.out.println("Contenido del fichero copiado con exito");
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
				salidaArchivoDestino.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
}
