package tests;
import clases.basicas.ProfesorImpl;
import clases.gestion.Gestion;

public class GestionTest
{
	public static void main(String[] args)
	{
		Gestion dep = new Gestion();
		
		/*
		Profesor cristina = new Profesor("Cristina", 'M', 41);
		Profesor carlos = new Profesor("Carlos", 'H', 29);
		Profesor celia = new Profesor("Celia", 'M', 40);
		Profesor cristobal = new Profesor("Cristobal", 'H', 49);
		Profesor clara = new Profesor("Clara", 'M', 55);
		
		dep.insertarProfesor(cristina);
		dep.insertarProfesor(carlos);
		dep.insertarProfesor(celia);
		dep.insertarProfesor(cristobal);
		dep.insertarProfesor(clara);
		* */
		
		ProfesorImpl[] array = {
		new ProfesorImpl(2, "Jesucristo", 'H', 400),
		new ProfesorImpl(3, "Maria", 'M', 43),
		new ProfesorImpl(4, "Ana", 'M', 29),
		new ProfesorImpl(5, "Pepe", 'H', 42),
		new ProfesorImpl(6, "Jesús", 'H', 31),
		new ProfesorImpl(7, "Iván", 'H', 63),
		};
		
		for(int i = 0 ; i < array.length ; i++)
		{
			dep.insertarProfesor2(array[i]);
		}
		
		//dep.insertarObjeto(cristina, "personal.txt");
		
		//File fichero = new File("personal.txt");
		
		//System.out.println(fichero.length());
		
		//System.out.println();
		
		ProfesorImpl masJoven = dep.profesorMasJoven();
		ProfesorImpl mayor = dep.profesorMayor();
		
		System.out.println();
		System.out.println("Nombre del mas joven: " + masJoven.getNombre() + "(" + masJoven.getEdad() + ")");
		System.out.println("Nombre del mayor: " + mayor.getNombre() + "(" + mayor.getEdad() + ")");
		System.out.println();
		
		dep.mostrarProfesores();
		
		System.out.println();
		
		System.out.println("Media de edad: " + dep.edadPromedio());
		System.out.println("Profesores por encima de la media de edad: " + dep.aboveAverageTeachers());
		System.out.println("Profesores por debajo de la media de edad: " + dep.belowAverageTeachers());
	}
}
