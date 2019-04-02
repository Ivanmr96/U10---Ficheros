package clases.utilidad;

import java.util.Scanner;

import clases.basicas.ProfesorImpl;
import clases.gestion.GestionTxt;

public class Validaciones 
{
	/* INTERFAZ
	 * Comentario: Muestra el menu principal y valida la opcion elegida
	 * Prototipo: public int mostrarMenuPrincipalYValidarOpcion()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: un entero con la opcion validada
	 * Postcondiciones: Asociado al nombre devuelve un entero con una de las opciones del menu principal
	 */
	public int mostrarMenuPrincipalYValidarOpcion()
	{
		int opcion = 0;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("MENU PRINCIPAL");
		System.out.println("1) Insertar profesor");
		System.out.println("2) Borrar profesor");
		System.out.println("3) Consultas sobre profesores");
		System.out.println("4) Salir");
		
		do
		{
			System.out.println("Elige una opcion: ");
			
			opcion = entrada.nextInt();
			
		}while(opcion < 1 || opcion > 4);
		
		return opcion;
	}
	
	/* INTERFAZ
	 * Comentario: Lee y valida los atributos para un profesor
	 * Prototipo: public ProfesorImpl leerYValidarProfesor()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: Un Profesor
	 * Postcondiciones: Asociado al nombre devuelve un objeto ProfesorImpl validado.
	 */
	public ProfesorImpl leerYValidarProfesor(String ruta)
	{
		ProfesorImpl profesor = null;
		Scanner entrada = new Scanner(System.in);
		GestionTxt gestion = new GestionTxt();
		int ID, edad;
		String nombre;
		char sexo;
		
		System.out.print("Inserta el ID: ");
		ID = entrada.nextInt();
		
		System.out.print("Inserta el nombre: ");
		//entrada.next();
		nombre = entrada.next();
		
		do
		{
			System.out.print("Inserta el sexo: ");
			
			sexo = Character.toUpperCase(entrada.next().charAt(0));
			
		}while(sexo != 'H' && sexo != 'M');
		
		do
		{
			System.out.print("Inserta la edad: ");
			
			edad = entrada.nextInt();
			
		}while(edad < 18 || edad > 100);
		
		profesor = new ProfesorImpl(ID, nombre, sexo, edad);
		
		return profesor;
	}
	
	/* INTERFAZ
	 * Comentario: Muestra el submenu de consultas sobre los profesores y valida la opcion
	 * Prototipo: public int mostrarSubMenuConsultasYValidarOpcion()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: Un entero con la opcion del submenu validada
	 * Psotcondiciones: Asociado al nombre devuelve un entero con la opcion del submenu validada
	 */
	public int mostrarSubMenuConsultasYValidarOpcion()
	{
		int opcion = 0;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("SUBMENU CONSULTAS");
		System.out.println("1) Mostrar profesores");
		System.out.println("2) Edad promedio");
		System.out.println("3) Profesor mayor");
		System.out.println("4) Profesor mas joven");
		System.out.println("5) Numero de profesores con edad por debajo de la media");
		System.out.println("6) Numero de profesores con edad por encima de la media");
		System.out.println("7) Volver atras");
		
		do
		{
			System.out.print("Elige una opcion: ");
			
			opcion = entrada.nextInt();
			
		}while(opcion < 1 || opcion > 7);
		
		return opcion;
	}
}
