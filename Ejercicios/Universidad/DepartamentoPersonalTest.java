import java.io.*;

public class DepartamentoPersonalTest
{
	public static void main(String[] args)
	{
		DepartamentoPersonal dep = new DepartamentoPersonal();
		
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
		
		dep.insertarProfesor(new Profesor(2, "Jesucristo", 'H', 3));
		
		//dep.insertarObjeto(cristina, "personal.txt");
		
		File fichero = new File("personal.txt");
		
		//System.out.println(fichero.length());
		
		//System.out.println();
		
		Profesor masJoven = dep.profesorMasJoven();
		Profesor mayor = dep.profesorMayor();
		
		System.out.println();
		System.out.println("Nombre del mas joven: " + masJoven.getNombre() + "(" + masJoven.getEdad() + ")");
		System.out.println("Nombre del mayor: " + mayor.getNombre() + "(" + mayor.getEdad() + ")");
		System.out.println();
		
		dep.mostrarProfesores();
		
		System.out.println();
		
		System.out.println("Media de edad: " + dep.edadPromedio());
	}
}
