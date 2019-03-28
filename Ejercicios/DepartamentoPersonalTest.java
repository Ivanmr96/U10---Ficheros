import java.io.*;

public class DepartamentoPersonalTest
{
	public static void main(String[] args)
	{
		DepartamentoPersonal dep = new DepartamentoPersonal();
		
		Profesor cristina = new Profesor("Cristina", 'M', 41);
		Profesor carlos = new Profesor("Carlos", 'H', 11);
		Profesor celia = new Profesor("Celia", 'M', 40);
		Profesor cristobal = new Profesor("Cristobal", 'H', 129);
		Profesor clara = new Profesor("Clara", 'M', 73);
		
		//dep.insertarProfesor(cristina);
		//dep.insertarProfesor(carlos);
		//dep.insertarProfesor(celia);
		//dep.insertarProfesor(cristobal);
		//dep.insertarProfesor(clara);
		
		dep.insertarObjeto(cristina, "personal.txt");
		
		File fichero = new File("personal.txt");
		
		System.out.println(fichero.length());
		
		System.out.println();
		
		Profesor masJoven = dep.profesorMasJoven();
		
		System.out.println("Nombre del mas joven: " + masJoven.getNombre() + "(" + masJoven.getEdad() + ")");
	}
}
