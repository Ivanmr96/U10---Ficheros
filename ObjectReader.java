import java.io.*;

public class ObjectReader
{
	public static void main(String[] args)
	{
		File archivo = null;
		ObjectInputStream entradaObjeto = null;
		FileInputStream entradaFichero = null;
		
		try
		{
			archivo = new File("objetos.txt");
			entradaFichero = new FileInputStream(archivo);
			entradaObjeto = new ObjectInputStream(entradaFichero);
			
			Persona persona = (Persona)entradaObjeto.readObject();
	
			while(persona != null)
			{
				System.out.println(persona.toString());
				System.out.println();
				persona = (Persona)entradaObjeto.readObject();
			}
			
			System.out.println(persona.toString());
			
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
	}
}
