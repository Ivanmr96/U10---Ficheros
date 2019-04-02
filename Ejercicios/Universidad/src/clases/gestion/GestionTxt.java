package clases.gestion;

import java.io.*;
import clases.basicas.ProfesorImpl;


public class GestionTxt
{	
	//TODO Método para actualizar un profesor

	/* INTERFAZ
	 * Comentario: Inserta un profesor en el fichero ruta
	 * Prototipo: public boolean insertarProfesor(ProfesorImpl prof)
	 * Entrada: Un profesor a insertar
	 * Precondiciones: No hay
	 * Salida: Un boolean indicando si se insertó correctamente el profesor o no
	 * Postcondiciones: Asociado al nombre devuelve:
	 * 					- True si se inserto correctamente el profesor
	 * 					- False si no se pudo insertar porque ya existe un profesor con el mismo ID.
	 */
	public boolean insertarProfesor(ProfesorImpl prof, String ruta)
	{
		boolean ret = false;
		File fichero = null;
		FileWriter writer = null;
		
		//Crea el fichero si no existe.
		try
		{
			fichero = new File(ruta);
			
			if(fichero.exists() == false)
				fichero.createNewFile();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		if(comprobarProfesor(prof.getID(), ruta) == false)	//Comprueba que el ID no exista ya en el fichero.
		{
			try
			{
				//fichero = new File(ruta);
				writer = new FileWriter(fichero, true);
			
				writer.write(prof.toString());			//Atributos del profesor
				writer.write(",0");						//Marcador de borrado
				writer.write(10);						//Salto de línea
				ret = true;
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
		return ret;
	}
	
	/* INTERFAZ
	 * Comentario: Busca un profesor por su ID
	 * Prototipo: public ProfesorImpl buscarPorID(int ID)
	 * Entrada: Un entero con la ID del profesor a buscar
	 * Precondiciones: El fichero ruta debe existir
	 * Salida: Un ProfesorImpl
	 * Postcondiciones: Asociado al nombre devuelve el Profesor correspondiente a la ID pasada por parametro,
	 * 					O bien null si no existe ningun profesor con esa ID.
	 */
	public ProfesorImpl buscarPorID(int ID, String ruta)
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		ProfesorImpl profesor = null;
		
		try
		{
			fichero = new File(ruta);
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			//int IDLeidoStr = reader.read();
			//String registro = br.readLine(); //Lee el primer registro
			
			String linea = br.readLine();	//Leer la primera línea
			String IDLeido = null;
			String[] array = null;
			
			if(linea != null)	//Si el registro no está vacio
			{
				array = linea.split(",");			//guardar los campos
				IDLeido = array[0];					//El primer ID
			}
			while(linea != null && Integer.parseInt(IDLeido) != ID)		//Si el registro no está vacío ni coincide con la ID a buscar.
			{
				linea = br.readLine();		//leer otra línea
				if(linea != null)
				{
					array = linea.split(",");
					IDLeido = array[0]; 	//El ID del siguiente
				}
			}
			
			if(linea != null)			//Si ha encontrado el ID
			{
				String nombre = array[1];
				String sexoStr = array[2];
				String edadStr = array[3];
				
				//System.out.println("" + IDLeido + nombre + sexoStr + edadStr);
				
				char sexo = sexoStr.charAt(0);
				int edad = Integer.parseInt(edadStr);
				
				profesor = new ProfesorImpl(ID, nombre, sexo, edad);
			}
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
				//entradaFichero.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return profesor;
	}
	
	/* INTERFAZ
	 * Comentario: Comprueba si existe un profesor buscandolo por su ID
	 * Prototipo: public boolean comprobarProfesor(int ID)
	 * Entrada: Un entero con la ID del profesor a comprobar
	 * Precondiciones: El fichero ruta debe existir
	 * Salida: Un boolean indicando si el profesor existe o no
	 * Postcondiciones: Asociado al nombre devuelve true si el profesor con la ID indicada existe, y false si no existe.
	 */
	public boolean comprobarProfesor(int ID, String ruta)
	{
		boolean ret = true;
		
		if(buscarPorID(ID, ruta) == null)
			ret = false;
		
		return ret;
	}
	
	//TODO Interfaz aqui
	public ProfesorImpl profesorMasJoven(String ruta)
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int ID = 0;
		String nombre = "";
		char sexo = ' ';
		int edad = 0;
		int marcaBorrado;
		ProfesorImpl masJoven = new ProfesorImpl(0, "", ' ', 10000);
		ProfesorImpl profesor;
		
		try
		{
			fichero = new File(ruta);
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			
			String linea = br.readLine(); 			//Lee el primer registro
		
			while(linea != null)
			{
				String[] campos = linea.split(",");
				
				ID = Integer.parseInt(campos[0]);
				nombre = campos[1];
				sexo = campos[2].charAt(0);
				edad = Integer.parseInt(campos[3]);
				marcaBorrado = Integer.parseInt(campos[4]);
				
				profesor = new ProfesorImpl(ID, nombre, sexo, edad);
				
				if(profesor.getEdad() < masJoven.getEdad() && marcaBorrado == 0)
					masJoven = profesor;
				
				linea = br.readLine();
			}
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				br.close();
				reader.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return masJoven;
	}
	
	//TODO Interfaz aqui
	public ProfesorImpl profesorMayor(String ruta)
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int ID = 0;
		String nombre = "";
		char sexo= ' ';
		int edad = 0;
		int marcaBorrado = 0;
		String[] campos;
		ProfesorImpl mayor = new ProfesorImpl(0, "", ' ', 0);
		ProfesorImpl profesor;
		
		try
		{
			fichero = new File(ruta);
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			String linea = br.readLine();			//Lee el primer registro
			
			while(linea != null)
			{
				campos = linea.split(",");
				
				ID = Integer.parseInt(campos[0]);
				nombre = campos[1];
				sexo = campos[2].charAt(0);
				edad = Integer.parseInt(campos[3]);
				marcaBorrado = Integer.parseInt(campos[4]);
				
				profesor = new ProfesorImpl(ID, nombre, sexo, edad);
				
				if(profesor.getEdad() > mayor.getEdad() && marcaBorrado == 0)
				{
					mayor = profesor;
				}
				
				linea = br.readLine(); 		//Lee el siguiente registro
			}
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				br.close();
				reader.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return mayor;
	}
	
	//TODO Interfaz aqui
	public void mostrarProfesores(String ruta)
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		String ID = "";
		String nombre = "";
		String sexo = "";
		String edad = "";
		int marcaBorrado;
		String[] campos;
		
		try
		{
			fichero = new File(ruta);
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			String linea = br.readLine();						//Lee el primer registro
			while(linea != null)
			{
				campos = linea.split(",");
				
				marcaBorrado = Integer.parseInt(campos[4]);
				
				if(marcaBorrado == 0)		//Si el profesor no está marcado como borrado.
				{
					ID = campos[0];
					nombre = campos[1];
					sexo = campos[2];
					edad = campos[3];
					
					System.out.println("ID: " + ID + "\n" +
									   "Nombre: " + nombre + "\n" + 
									   "Sexo: " + sexo + "\n" +
									   "Edad: " + edad + "\n");
				}
				
				linea = br.readLine(); //Lee el siguiente registro
			}
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				br.close();
				reader.close();
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
	public double edadPromedio(String ruta)
	{
		double media;
		
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int acumuladorEdad = 0;
		int contadorProfesores = 0;
		String[] campos;
		int edad, marcaBorrado;
		
		try
		{
			fichero = new File(ruta);
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			String linea = br.readLine();				//Lee el primer registro
		
			while(linea != null)
			{
				campos = linea.split(",");
				
				marcaBorrado = Integer.parseInt(campos[4]);
				
				if(marcaBorrado == 0)
				{
					edad = Integer.parseInt(campos[3]);
					
					acumuladorEdad += edad;
					contadorProfesores++;
				}

				linea = br.readLine();					//Lee el siguiente registro
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				br.close();
				reader.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		media = (double)acumuladorEdad / contadorProfesores;
		
		return media;
	}

	/* INTERFAZ
	 * Comentario: Cuenta el numero de profesores que están por encima de la media de edad en el fichero personal.txt
	 * Prototipo: public int belowAverageTeachers()
	 * Entrada: No hay
	 * Precondiciones: El fichero ruta debe existir
	 * Salida: Un int con el numero de profesores por encima de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por encima del a media de edad en el fichero personal.txt
	 */
	public int aboveAverageTeachers(String ruta)
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int contadorProfesores = 0;
		String[] campos;
		int edad, marcaBorrado;
		
		try
		{
			fichero = new File(ruta);
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			//ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			String linea = br.readLine();						//Lee el primer registro
			
			while(linea != null)
			{
				campos = linea.split(",");
				
				edad = Integer.parseInt(campos[3]);
				marcaBorrado = Integer.parseInt(campos[4]);			//Lee la marca de borrado
				
				if(marcaBorrado == 0 && edad < edadPromedio(ruta))
					contadorProfesores++;
				
				linea = br.readLine();		//Lee el siguient registro
			}
		}
		catch(EOFException e)
		{
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				br.close();
				reader.close();
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
	 * Precondiciones: El fichero ruta debe existir
	 * Salida: Un int con el numero de profesores por debajo de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por debajo del a media de edad en el fichero personal.txt
	 */
	public int belowAverageTeachers(String ruta)
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int contadorProfesores = 0;
		String[] campos;
		int edad, marcaBorrado;
		
		try
		{
			fichero = new File(ruta);
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			

			String linea = br.readLine();						//Lee el primer registro
			
			while(linea != null)
			{
				campos = linea.split(",");
				
				edad = Integer.parseInt(campos[3]);
				marcaBorrado = Integer.parseInt(campos[4]);			//Lee la marca de borrado
				
				if(marcaBorrado == 0 && edad > edadPromedio(ruta))
					contadorProfesores++;
				
				linea = br.readLine();		//Lee el siguient registro
			}
		}
		catch(EOFException e)
		{
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				br.close();
				reader.close();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		return contadorProfesores;
	}
	
	//TODO Interfaz aqui
	public boolean borrarProfesor(int ID, String ruta)
	{
		boolean exito = false;
		
		System.out.println("borrarProfesor en resguardo.");		//TODO Implementar borrarProfesor(int ID)
		
		return exito;
	}
}
