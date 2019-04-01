package tests;
//import java.io.File;

import clases.basicas.ProfesorImpl;
import clases.gestion.Gestion;

public class GestionTest
{
	public static void main(String[] args)
	{
		Gestion dep = new Gestion();
		
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
			dep.insertarProfesor2(array[i]);
		} 
		
		int id = 4;
		
		System.out.println("Intentando insertar un profesor con una ID ya existente...");
		System.out.print("dep.insertarProfesor(new ProfesorImpl("+id+", \"Pedro\", 'H', 40)): ");
		boolean insertado = dep.insertarProfesor2(new ProfesorImpl(id, "Pedro", 'H', 40));
		if(insertado == false)
			System.out.println("Ya existe un profesor con la ID "+id);
		
		
		System.out.println();
		System.out.println("Buscando un profesor por ID...");
		System.out.println("dep.buscarPorID(4):");
		if(dep.comprobarProfesor(4))
		{
			ProfesorImpl profesor = dep.buscarPorID(4);
			System.out.println(profesor.toString());
		}
		
		/*
		ProfesorImpl masJoven = dep.profesorMasJoven2();
		ProfesorImpl mayor = dep.profesorMayor2();
		double media = dep.edadPromedio2();
		
		System.out.println("dep.profesorMasJoven(): " + masJoven.getNombre() + "(" + masJoven.getEdad() + ")" );
		System.out.println("dep.profesorMayor(): " + mayor.getNombre() + "(" + mayor.getEdad() + ")" );
		System.out.println("dep.edadPromedio(): " + media);
		System.out.println("Profesores por encima de la media de edad: " + dep.aboveAverageTeachers2());
		System.out.println("Profesores por debajo de la media de edad: " + dep.belowAverageTeachers2());

		
		System.out.println();

		System.out.println("dep.mostrarProfesores(): ");
		dep.mostrarProfesores2();
		 */
	}
}
