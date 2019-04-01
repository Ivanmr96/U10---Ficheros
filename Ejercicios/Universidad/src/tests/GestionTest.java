package tests;
//import java.io.File;

import clases.basicas.ProfesorImpl;
import clases.gestion.GestionTxt;

public class GestionTest
{
	public static void main(String[] args)
	{
		GestionTxt dep = new GestionTxt("profesores.txt");
		
		ProfesorImpl[] array = {
		new ProfesorImpl(2, "Raul", 'H', 39),
		new ProfesorImpl(3, "Maria", 'M', 43),
		new ProfesorImpl(4, "Ana", 'M', 29),
		new ProfesorImpl(5, "Pepe", 'H', 42),
		new ProfesorImpl(6, "Jesús", 'H', 31),
		new ProfesorImpl(7, "Iván", 'H', 63),
		};
		
		for(int i = 0 ; i < array.length ; i++)
		{
			dep.insertarProfesor(array[i]);
		} 
		
		int id = 4;
		
		System.out.println("Intentando insertar un profesor con una ID ya existente...");
		System.out.print("dep.insertarProfesor(new ProfesorImpl("+id+", \"Pedro\", 'H', 40)): ");
		boolean insertado = dep.insertarProfesor(new ProfesorImpl(id, "Pedro", 'H', 40));
		if(insertado == false)
			System.out.println("Ya existe un profesor con la ID "+id);
		
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		System.out.println("Buscando un profesor por ID...");
		System.out.print("dep.buscarPorID(4): ");
		if(dep.comprobarProfesor(4))
		{
			ProfesorImpl profesor = dep.buscarPorID(4);
			System.out.println(profesor.toString());
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		ProfesorImpl masJoven = dep.profesorMasJoven();
		ProfesorImpl mayor = dep.profesorMayor();
		double media = dep.edadPromedio();
		
		System.out.println("dep.profesorMasJoven(): " + masJoven.getNombre() + "(" + masJoven.getEdad() + " años)" );
		System.out.println("dep.profesorMayor(): " + mayor.getNombre() + "(" + mayor.getEdad() + " años)" );
		System.out.println("dep.edadPromedio(): " + media);
		System.out.println("Profesores por encima de la media de edad: " + dep.aboveAverageTeachers());
		System.out.println("Profesores por debajo de la media de edad: " + dep.belowAverageTeachers());
		
		System.out.println("------------------------------------------------------------------------------------------------");

		System.out.println();

		System.out.println("dep.mostrarProfesores(): ");
		dep.mostrarProfesores();
		
	}
}
