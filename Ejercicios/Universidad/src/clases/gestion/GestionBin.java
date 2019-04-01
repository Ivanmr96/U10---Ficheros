package clases.gestion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import clases.basicas.ProfesorImpl;
import clases.utilidad.Utilidades;

public class GestionBin 
{
	private String ruta;
	
	public GestionBin(String ruta){ this.ruta = ruta; }
	
	/* INTERFAZ
	 * Comentario: Inserta un profesor en el fichero ruta
	 * Prototipo: public void insertarProfesor(ProfesorImpl prof)
	 * Entrada: Un profesor a insertar
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: El fichero ruta se modifica, insertando al final el profesor indicado
	 */
	public void insertarProfesor(ProfesorImpl prof)
	{
		Utilidades utils = new Utilidades();
		
		utils.insertarObjeto(prof, ruta);
	}
	
	/* INTERFAZ
	 * Comentario: Busca el profesor más joven en el fichero ruta
	 * Prototipo: public ProfesorImpl profesorMasJoven()
	 * Entrada: No hay
	 * Precondiciones: El fichero ruta debe existir y tener al menos un profesor
	 * Salida: Un Profesor
	 * Postcondiciones: Asociado al nombre devuelve el profesor más joven
	 */
	public ProfesorImpl profesorMasJoven()
	{
		ProfesorImpl masJoven = new ProfesorImpl(0, " ", '-', 100);
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File(ruta);
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			while(profesor != null)
			{
				profesor = (ProfesorImpl)reader.readObject();
				
				if(profesor.getEdad() < masJoven.getEdad())
					masJoven = profesor;
			}
		}
		catch(EOFException e){}
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
				reader.close();
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return masJoven;
	}
	
	/* INTERFAZ
	 * Comentario: Busca el profesor con más edad en el fichero ruta
	 * Prototipo: public ProfesorImpl profesorMayor()
	 * Entrada: No hay
	 * Precondiciones: El fichero ruta debe existir y tener al menos un profesor
	 * Salida: Un Profesor
	 * Postcondiciones: Asociado al nombre devuelve el profesor con más edad.
	 */
	public ProfesorImpl profesorMayor()
	{
		ProfesorImpl mayor = new ProfesorImpl(0, " ", '-', 0);
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File(ruta);
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			while(profesor != null)
			{
				profesor = (ProfesorImpl)reader.readObject();
				if(profesor.getEdad() > mayor.getEdad())
					mayor = profesor;
			}
		}
		catch(EOFException e){}
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
				reader.close();
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return mayor;
	}
	
	/* INTERFAZ
	 * Comentario: Muestra en pantalla todos los profesores del fichero ruta
	 * Prototipo: public void mostrarProfesores()
	 * Entrada: No hay
	 * Precondiciones: El fichero ruta debe existir y tener al menos un profesor
	 * Salida: No hay
	 * Postcondiciones: No hay. Imprime en pantalla todos los profesores del fichero ruta
	 */
	public void mostrarProfesores()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File(ruta);
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			
			ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			while(profesor != null)
			{
				System.out.println(profesor.toString());
				System.out.println();
				profesor = (ProfesorImpl)reader.readObject();
			}
		}
		catch(EOFException e)
		{
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
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
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	
	/* INTERFAZ
	 * Comentario: Calcula la edad promedio de todos los profesores del fichero ruta
	 * Prototipo: public double edadPromedio()
	 * Entrada: No hay
	 * Precondiciones: El fichero ruta debe existir y tener al menos un profesor
	 * Salida: Un double con la edad media
	 * Postcondiciones: Asociado al nombre devuelve la media de edad de los profesores del fichero ruta
	 */
	public double edadPromedio()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		int contadorProfesores = 0;
		double media;
		double acumuladorEdades = 0;
		
		try
		{
			fichero = new File(ruta);
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			
			ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			contadorProfesores++;
			acumuladorEdades += profesor.getEdad();
			while(profesor != null)
			{
				profesor = (ProfesorImpl)reader.readObject();
				contadorProfesores++;
				acumuladorEdades += profesor.getEdad();
			}
		}
		catch(EOFException e)
		{
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
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
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		media = acumuladorEdades / contadorProfesores;
		
		return media;
	}
	
	/* INTERFAZ
	 * Comentario: Cuenta el numero de profesores que están por encima de la media de edad en el fichero personal.txt
	 * Prototipo: public int belowAverageTeachers()
	 * Entrada: No hay
	 * Precondiciones: El fichero ruta debe existir y tener al menos un profesor
	 * Salida: Un int con el numero de profesores por encima de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por encima del a media de edad en el fichero personal.txt
	 */
	public int aboveAverageTeachers()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		int contadorProfesores = 0;
		
		try
		{
			fichero = new File(ruta);
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			
			ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			while(profesor != null)
			{
				if(profesor.getEdad() > edadPromedio())
					contadorProfesores++;
				
				profesor = (ProfesorImpl)reader.readObject();
			}
		}
		catch(EOFException e)
		{
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
				reader.close();
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return contadorProfesores;
	}
	
	/* INTERFAZ
	 * Comentario: Cuenta el numero de profesores que están por debajo de la media de edad en el fichero personal.txt
	 * Prototipo: public int belowAverageTeachers()
	 * Entrada: No hay
	 * Precondiciones: El fichero ruta debe existir y tener al menos un profesor
	 * Salida: Un int con el numero de profesores por debajo de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por debajo del a media de edad en el fichero personal.txt
	 */
	public int belowAverageTeachers()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		int contadorProfesores = 0;
		
		try
		{
			fichero = new File(ruta);
			entradaFichero = new FileInputStream(fichero);
			reader = new ObjectInputStream(entradaFichero);
			
			ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			while(profesor != null)
			{
				if(profesor.getEdad() < edadPromedio())
					contadorProfesores++;
				
				profesor = (ProfesorImpl)reader.readObject();
			}
		}
		catch(EOFException e)
		{
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
				reader.close();
				entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return contadorProfesores;
	}
	
	
}
