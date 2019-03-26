import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

import java.util.Scanner;



public class PresentacionInputYOutput2
{
	public static void main(String[] args)
	{
		File ficheroOrigen = null;
		File ficheroDestino = null;
		
		FileInputStream entradaArchivoOrigen = null;
		FileOutputStream salidaArchivoDestino = null;
	
		InputStreamReader reader = null;
		OutputStreamWriter writer = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		char[] array = null;
		
		//Leemos el fichero de origen y lo guardamos en memoria
		try
		{
			ficheroOrigen = new File("imagen.jpg");
			entradaArchivoOrigen = new FileInputStream(ficheroOrigen);
			reader = new InputStreamReader(entradaArchivoOrigen);
			br = new BufferedReader(reader);
			
			ficheroDestino = new File("destinoo2.bmp");
			salidaArchivoDestino = new FileOutputStream(ficheroDestino);
			writer = new OutputStreamWriter(salidaArchivoDestino);
			bw = new BufferedWriter(writer);
			
			int tamanhoFichero = (int)ficheroOrigen.length();
			
			System.out.println("Tamanho: " + tamanhoFichero);
			
			//array = new char[tamanhoFichero];
			
			for(int i = 0 ; i < tamanhoFichero; i ++)
			{
				bw.write(br.read());
				bw.flush();
			}
			
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
		
		//System.out.println();
		
		/*System.out.println("--------------------------------------------------------------------");
		System.out.println("Contenido del archivo copiado en memoria:");
		System.out.println();
		for(int i = 0 ; i < array.length ; i++)
		{
			System.out.print(array[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------------");*/
		
		//Escribe en el fichero de destino el array guardado en memoria, que contiene el texto del fichero de origen ya leido.
		
	}
}
