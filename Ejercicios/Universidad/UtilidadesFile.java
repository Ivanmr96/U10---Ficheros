//package clases;
import java.io.*;
public class UtilidadesFile 
{
	/* INTERFAZ
	 * Comentario: Lista el contenido de un directorio
	 * Prototipo: public void listarContenido(String ruta)
	 * Entrada: La ruta del directorio
	 * Precondiciones: El directorio debe existir
	 * Salida: Nada.
	 * Postcondiciones: Nada. solo imprime en pantalla el contenido del directorio.
	 */
	public void listarContenido(String ruta)
	{
		File directorio = new File(ruta);
		
		String[] contenido = directorio.list();
		
		for(String element:contenido)
		{
			System.out.println(element);
		}
	}
	
	/* INTERFAZ
	 * Comentario: realiza una copia de un fichero de texto
	 * Prototipo: public void copiaFicheroTexto(String rutaFicheroExistente, String rutaFicheroNuevo)
	 * Entrada: - Un String para la ruta del fichero a copiar
	 * 			- Otro String para la ruta que tendrá el fichero nuevo.
	 * Precondiciones: El fichero a copiar debe existir
	 * Salida: No hay.
	 * Postcondiciones: Crea un fichero nuevo en la ruta especificada, que será igual al fichero existente indicado.
	 */
	public void copiaFicheroTexto(String rutaFicheroExistente, String rutaFicheroNuevo)
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
			ficheroOrigen = new File(rutaFicheroExistente);
			entradaArchivoOrigen = new FileInputStream(ficheroOrigen);
			reader = new InputStreamReader(entradaArchivoOrigen);
			
			int tamanhoFichero = (int)ficheroOrigen.length();
			
			array = new char[tamanhoFichero];
			
			reader.read(array);
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
		//Escribe en el fichero de destino el array guardado en memoria, que contiene el texto del fichero de origen ya leido.
		try
		{
			ficheroDestino = new File(rutaFicheroNuevo);
			salidaArchivoDestino = new FileOutputStream(ficheroDestino);
			writer = new OutputStreamWriter(salidaArchivoDestino);
			
			writer.write(array);
			
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
				salidaArchivoDestino.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
}
