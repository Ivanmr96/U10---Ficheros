package clases.gestion;

import java.io.*;

import clases.basicas.ProfesorImpl;
import clases.utilidad.Utilidades;


public class Gestion
{	
	//TODO Métodos para buscar un profesor en el fichero, borrar un profesor, actualizar un profesor
	//TODO Modificar los métodos profesorMasJoven, profesorMayor, edadPromedio, mostrarProfesores, aboveAverageTeachers y belowAverageTeachers
	public void insertarProfesor(ProfesorImpl prof)
	{
		Utilidades utils = new Utilidades();
		
		utils.insertarObjeto(prof, "personal.txt");
	}
	
	public void insertarProfesor2(ProfesorImpl prof)
	{
		File fichero = null;
		FileWriter writer = null;
		
		try
		{
			fichero = new File("personal.txt");
			//fichero.createNewFile();
			writer = new FileWriter(fichero, true);
			
			/*writer.write(Integer.toString(prof.getID()));
			writer.write(" ");
			writer.write(prof.getNombre());
			writer.write(" ");
			writer.write(prof.getSexo());
			writer.write(" ");
			writer.write(Integer.toString(prof.getEdad()));*/
			writer.write(prof.toString());
			writer.write(" 0");
			writer.write(10);
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
	
	public ProfesorImpl profesorMasJoven()
	{
		ProfesorImpl masJoven = new ProfesorImpl(0, " ", '-', 100);
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File("personal.txt");
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
	
	public ProfesorImpl profesorMayor()
	{
		ProfesorImpl mayor = new ProfesorImpl(0, " ", '-', 0);
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File("personal.txt");
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
	
	public void mostrarProfesores()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		
		try
		{
			fichero = new File("personal.txt");
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
			fichero = new File("personal.txt");
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
	
	public int aboveAverageTeachers()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		int contadorProfesores = 0;
		
		try
		{
			fichero = new File("personal.txt");
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
	
	public int belowAverageTeachers()
	{
		File fichero = null;
		FileInputStream entradaFichero = null;
		ObjectInputStream reader = null;
		int contadorProfesores = 0;
		
		try
		{
			fichero = new File("personal.txt");
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
