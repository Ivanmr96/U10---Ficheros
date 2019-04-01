package clases.gestion;

import java.io.*;

import clases.basicas.ProfesorImpl;
import clases.utilidad.Utilidades;


public class Gestion
{	
	//TODO Métodos para borrar un profesor y actualizar un profesor
	
	/* INTERFAZ
	 * Comentario: Inserta un profesor en el fichero "personal.txt"
	 * Prototipo: public void insertarProfesor(ProfesorImpl prof)
	 * Entrada: Un profesor a insertar
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: El fichero "personal.txt" se modifica, insertando al final el profesor indicado
	 */
	public void insertarProfesor(ProfesorImpl prof)
	{
		Utilidades utils = new Utilidades();
		
		utils.insertarObjeto(prof, "personal.txt");
	}
	
	/* INTERFAZ
	 * Comentario: Inserta un profesor en el fichero "personal.txt"
	 * Prototipo: public boolean insertarProfesor(ProfesorImpl prof)
	 * Entrada: Un profesor a insertar
	 * Precondiciones: No hay
	 * Salida: Un boolean indicando si se insertó correctamente el profesor o no
	 * Postcondiciones: Asociado al nombre devuelve:
	 * 					- True si se inserto correctamente el profesor
	 * 					- False si no se pudo insertar porque ya existe un profesor con el mismo ID.
	 */
	public boolean insertarProfesor2(ProfesorImpl prof)
	{
		boolean ret = false;
		File fichero = null;
		FileWriter writer = null;
		
		//Crea el fichero si no existe.
		try
		{
			fichero = new File("personal.txt");
			
			if(fichero.exists() == false)
				fichero.createNewFile();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		if(comprobarProfesor(prof.getID()) == false)	//Comprueba que el ID no exista ya en el fichero.
		{
			try
			{
				//fichero = new File("personal.txt");
				writer = new FileWriter(fichero, true);
			
				writer.write(prof.toString());			//Atributos del profesor
				writer.write("\n0\n");					//Marcador de borrado
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
	 * Precondiciones: El fichero "personal.txt" debe existir
	 * Salida: Un ProfesorImpl
	 * Postcondiciones: Asociado al nombre devuelve el Profesor correspondiente a la ID pasada por parametro,
	 * 					O bien null si no existe ningun profesor con esa ID.
	 */
	public ProfesorImpl buscarPorID(int ID)
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		ProfesorImpl profesor = null;
		
		try
		{
			fichero = new File("personal.txt");
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			
			//int IDLeidoStr = reader.read();
			String IDLeido = br.readLine();						//Lee el primer ID
			while(IDLeido != null && Integer.parseInt(IDLeido) != ID)
			{
				br.readLine(); //Para saltar el nombre
				br.readLine(); //Para saltar el sexo
				br.readLine(); //Para saltar la edad
				br.readLine(); //Para saltar el indicador de borrado
				br.readLine(); //Salta el espacio en blanco entre cada registro
				IDLeido = br.readLine(); //Lee el ID del siguiente
			}
			
			if(IDLeido != null)
			{
				String nombre = br.readLine();
				String sexoStr = br.readLine();
				String edadStr = br.readLine();
				
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
	 * Precondiciones: El fichero "personal.txt" debe existir
	 * Salida: Un boolean indicando si el profesor existe o no
	 * Postcondiciones: Asociado al nombre devuelve true si el profesor con la ID indicada existe, y false si no existe.
	 */
	public boolean comprobarProfesor(int ID)
	{
		boolean ret = true;
		
		if(buscarPorID(ID) == null)
			ret = false;
		
		return ret;
	}
	
	/* INTERFAZ
	 * Comentario: Busca el profesor más joven en el fichero "personal.txt"
	 * Prototipo: public ProfesorImpl profesorMasJoven()
	 * Entrada: No hay
	 * Precondiciones: El fichero "personal.txt" debe existir y tener al menos un profesor
	 * Salida: Un Profesor
	 * Postcondiciones: Asociado al nombre devuelve el profesor más joven
	 */
	@Deprecated
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
	
	public ProfesorImpl profesorMasJoven2()
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		String ID = "";
		String nombre = "";
		String sexoStr = "";
		String edadStr = "";
		String marcaBorrado = "";
		ProfesorImpl masJoven = new ProfesorImpl(0, "", ' ', 100);
		
		try
		{
			fichero = new File("personal.txt");
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			ID = br.readLine();						//Lee el primer ID
			nombre = br.readLine();					//Lee el primer nombre
			sexoStr = br.readLine();				//Lee el primer sexo
			edadStr = br.readLine();				//Lee la primera edad
			marcaBorrado = br.readLine();			//Lee la primera marca de borrado
			while(ID != null)
			{
				if(Integer.parseInt(edadStr) < masJoven.getEdad() && Integer.parseInt(marcaBorrado) == 0)
				{
					masJoven = new ProfesorImpl(Integer.parseInt(ID), 
												nombre, 
												sexoStr.charAt(0), 
												Integer.parseInt(edadStr));
				}
				br.readLine(); //Lee el espacio en blanco entre profesores
				ID = br.readLine(); //Lee el ID del siguiente
				nombre = br.readLine();
				sexoStr = br.readLine();
				edadStr = br.readLine();
				marcaBorrado = br.readLine();
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
	
	/* INTERFAZ
	 * Comentario: Busca el profesor con más edad en el fichero "personal.txt"
	 * Prototipo: public ProfesorImpl profesorMayor()
	 * Entrada: No hay
	 * Precondiciones: El fichero "personal.txt" debe existir y tener al menos un profesor
	 * Salida: Un Profesor
	 * Postcondiciones: Asociado al nombre devuelve el profesor con más edad.
	 */
	@Deprecated
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
	
	public ProfesorImpl profesorMayor2()
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		String ID = "";
		String nombre = "";
		String sexoStr = "";
		String edadStr = "";
		String marcaBorrado = "";
		ProfesorImpl mayor = new ProfesorImpl(0, "", ' ', 0);
		
		try
		{
			fichero = new File("personal.txt");
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			ID = br.readLine();						//Lee el primer ID
			nombre = br.readLine();					//Lee el primer nombre
			sexoStr = br.readLine();				//Lee el primer sexo
			edadStr = br.readLine();				//Lee la primera edad
			marcaBorrado = br.readLine();			//Lee la primera marca de borrado
			while(ID != null)
			{
				if(Integer.parseInt(edadStr) > mayor.getEdad() && Integer.parseInt(marcaBorrado) == 0)
				{
					mayor = new ProfesorImpl(Integer.parseInt(ID), 
												nombre, 
												sexoStr.charAt(0), 
												Integer.parseInt(edadStr));
				}
				br.readLine(); //Lee el espacio en blanco entre profesores
				ID = br.readLine(); //Lee el ID del siguiente
				nombre = br.readLine();
				sexoStr = br.readLine();
				edadStr = br.readLine();
				marcaBorrado = br.readLine();
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
	
	/* INTERFAZ
	 * Comentario: Muestra en pantalla todos los profesores del fichero "personal.txt"
	 * Prototipo: public void mostrarProfesores()
	 * Entrada: No hay
	 * Precondiciones: El fichero "personal.txt" debe existir y tener al menos un profesor
	 * Salida: No hay
	 * Postcondiciones: No hay. Imprime en pantalla todos los profesores del fichero "personal.txt"
	 */
	@Deprecated
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
	
	public void mostrarProfesores2()
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		String ID = "";
		String nombre = "";
		String sexoStr = "";
		String edadStr = "";
		String marcaBorrado = "";
		ProfesorImpl profesor = null;
		
		try
		{
			fichero = new File("personal.txt");
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			ID = br.readLine();						//Lee el primer ID
			nombre = br.readLine();					//Lee el primer nombre
			sexoStr = br.readLine();				//Lee el primer sexo
			edadStr = br.readLine();				//Lee la primera edad
			marcaBorrado = br.readLine();			//Lee la primera marca de borrado
			while(ID != null)
			{
				
				if(Integer.parseInt(marcaBorrado) == 0)		//Si el profesor no está marcado como borrado.
				{
					profesor = new ProfesorImpl(Integer.parseInt(ID), 
												nombre, 
												sexoStr.charAt(0), 
												Integer.parseInt(edadStr));
					
					System.out.println(profesor.toString());
				}
				
				br.readLine(); //Lee el espacio en blanco entre profesores
				ID = br.readLine(); //Lee el ID del siguiente
				nombre = br.readLine();
				sexoStr = br.readLine();
				edadStr = br.readLine();
				marcaBorrado = br.readLine();
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
	 * Comentario: Calcula la edad promedio de todos los profesores del fichero "personal.txt"
	 * Prototipo: public double edadPromedio()
	 * Entrada: No hay
	 * Precondiciones: El fichero "personal.txt" debe existir y tener al menos un profesor
	 * Salida: Un double con la edad media
	 * Postcondiciones: Asociado al nombre devuelve la media de edad de los profesores del fichero "personal.txt"
	 */
	@Deprecated
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
	
	/* INTERFAZ
	 * Comentario: Calcula la edad promedio de todos los profesores del fichero "personal.txt"
	 * Prototipo: public double edadPromedio()
	 * Entrada: No hay
	 * Precondiciones: El fichero "personal.txt" debe existir y tener al menos un profesor
	 * Salida: Un double con la edad media
	 * Postcondiciones: Asociado al nombre devuelve la media de edad de los profesores del fichero "personal.txt"
	 */
	public double edadPromedio2()
	{
		double media;
		
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int acumuladorEdad = 0;
		int contadorProfesores = 0;
		
		try
		{
			fichero = new File("personal.txt");
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			br.readLine();								//Salta el primer ID
			br.readLine();								//Salta el primer nombre
			br.readLine();								//Salta el primer sexo
			
			String edadStr = br.readLine();				//Lee la primera edad
			if(edadStr != null)
			{
				acumuladorEdad += Integer.parseInt(edadStr);
				contadorProfesores++;
			}
			br.readLine();			//Salta la primera marca de borrado
			while(edadStr != null)
			{
				br.readLine(); 					//Lee el espacio en blanco entre profesores
				br.readLine(); 					//Salta el ID del siguiente
				br.readLine();					//Salta el nombre
				br.readLine();					//Salta el sexo
				
				edadStr = br.readLine();
				if(edadStr != null)
				{
					acumuladorEdad += Integer.parseInt(edadStr);
					contadorProfesores++;
				}
				
				br.readLine();					//Salta la marca de borrado
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
	 * Precondiciones: El fichero "personal.txt" debe existir y tener al menos un profesor
	 * Salida: Un int con el numero de profesores por encima de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por encima del a media de edad en el fichero personal.txt
	 */
	@Deprecated
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
	
	/* INTERFAZ
	 * Comentario: Cuenta el numero de profesores que están por encima de la media de edad en el fichero personal.txt
	 * Prototipo: public int belowAverageTeachers()
	 * Entrada: No hay
	 * Precondiciones: El fichero "personal.txt" debe existir
	 * Salida: Un int con el numero de profesores por encima de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por encima del a media de edad en el fichero personal.txt
	 */
	public int aboveAverageTeachers2()
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int contadorProfesores = 0;
		ProfesorImpl profesor = null;
		
		String ID, nombre, sexoStr, edadStr, marcaBorrado;
		
		try
		{
			fichero = new File("personal.txt");
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			//ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			ID = br.readLine();						//Lee el primer ID
			
			while(ID != null)
			{
				nombre = br.readLine();					//Lee el nombre
				sexoStr = br.readLine();				//Lee el sexo
				edadStr = br.readLine();				//Lee la edad
				marcaBorrado = br.readLine();			//Lee la marca de borrado
				
				if(Integer.parseInt(marcaBorrado) == 0)
				{
					profesor = new ProfesorImpl(Integer.parseInt(ID), nombre, sexoStr.charAt(0), Integer.parseInt(edadStr));
					
					if(profesor.getEdad() > edadPromedio2())
						contadorProfesores++;
				}
				
				br.readLine();		//Linea vacia entre cada registro de Profesor
				ID = br.readLine();
				//profesor = (ProfesorImpl)reader.readObject();
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
	 * Precondiciones: El fichero "personal.txt" debe existir y tener al menos un profesor
	 * Salida: Un int con el numero de profesores por debajo de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por debajo del a media de edad en el fichero personal.txt
	 */
	@Deprecated
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
	
	/* INTERFAZ
	 * Comentario: Cuenta el numero de profesores que están por debajo de la media de edad en el fichero personal.txt
	 * Prototipo: public int belowAverageTeachers()
	 * Entrada: No hay
	 * Precondiciones: El fichero "personal.txt" debe existir
	 * Salida: Un int con el numero de profesores por debajo de la media de edad
	 * Postcondiciones: Asociado al nombre devuelve el número de profesores por debajo del a media de edad en el fichero personal.txt
	 */
	public int belowAverageTeachers2()
	{
		File fichero = null;
		FileReader reader = null;
		BufferedReader br = null;
		int contadorProfesores = 0;
		ProfesorImpl profesor = null;
		
		String ID, nombre, sexoStr, edadStr, marcaBorrado;
		
		try
		{
			fichero = new File("personal.txt");
			reader = new FileReader(fichero);
			br = new BufferedReader(reader);
			
			//ProfesorImpl profesor = (ProfesorImpl)reader.readObject();
			ID = br.readLine();						//Lee el primer ID
			
			while(ID != null)
			{
				nombre = br.readLine();					//Lee el nombre
				sexoStr = br.readLine();				//Lee el sexo
				edadStr = br.readLine();				//Lee la edad
				marcaBorrado = br.readLine();			//Lee la marca de borrado
				
				if(Integer.parseInt(marcaBorrado) == 0)
				{
					profesor = new ProfesorImpl(Integer.parseInt(ID), nombre, sexoStr.charAt(0), Integer.parseInt(edadStr));
					
					if(profesor.getEdad() < edadPromedio2())
						contadorProfesores++;
				}
				
				br.readLine();		//Linea vacia entre cada registro de Profesor
				ID = br.readLine();
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
}
