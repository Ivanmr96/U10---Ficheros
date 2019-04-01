import java.util.Scanner;

import clases.basicas.ProfesorImpl;
import clases.gestion.GestionTxt;
import clases.utilidad.Validaciones;

/* ANALISIS
 * 
 * Un programa para gestionar los profesores de una universidad, en él se podrán insertar, borrar y consultar sobre los profesores.
 * 
 * El programa tendrá un menu principal con 4 opciones:
 * 
 * 1) Insertar un profesor
 * 2) Borrar un profesor
 * 3) Consultar sobre los profesores
 * 4) Salir
 * 
 * Entrada:
 * 	- Una opcion elegida para el menu principal
 * 	- Una opcion elegida para el submenu de consultas sobre profesores
 * 	- Un profesor para insertar (ID, nombre, sexo, edad)
 * 	- Una ID para borrar un profesor
 * 
 * Salida:
 *  - Un menu principal con 4 opciones:
 * 		1) Insertar un profesor
 * 		2) Borrar un profesor
 * 		3) Consultar sobre los profesores
 * 		4) Salir
 * 
 *  - Un submenu para las distintas consultas sobre los profesores:
 *  	1) Mostrar todos los profesores
 *  	2) Edad promedio de los profesores
 *  	3) Nombre del profesor con más edad
 *  	4) Nombre del profesor más joven
 *  	5) Número de profesores por encima de la media de edad
 *  	6) Número de profesores por debajo de la media de edad
 *  	7) Volver atrás
 *  
 *  - Distintos mensajes de ayuda al usuario
 *  
 * Restricciones:
 * 	- La opcion elegida del menu principal debe ser un numero entre 1 y 4
 * 	- La opcion elegida del submenu para consultar datos sobre los profesores debe ser un numero entre 1 y 7
 * 	- Para insertar un profesor:
 * 		-> El sexo debe ser un caracter 'H' o 'M'
 * 		-> La edad debe ser un número entre 18 y 100
 */

/* PSEUDOCODIGO GENERALIZADO (Nivel 0)
 * Inicio
 * 	Mostrar menu principal y validar opcion *
 * 	Mientras(opcionMenuPrincipal no sea salir)
 * 		Para(opcionMenuPrincipal)
 * 			caso 1:
 * 				insertarProfesor *
 * 			caso 2:
 * 				borrarProfesor *
 * 			caso 3:
 * 				subMenuConsultas 
 * 		FinPara
 * 		Mostrar menu principal y validar opcion *
 * 	FinMientras
 * Fin
 */

/* PSEUDOCODIGO MODULOS
 * 
 * - Modulo subMenuConsultas
 * Inicio
 * 	Mostrar subMenuConsultas y validar opcion *
 * 	Mientras(opcionSubMenu no sea salir)
 * 		Para(opcionSubMenu)
 * 			caso 1:
 * 				mostrarProfesores *
 * 			caso 2:
 * 				edadPromedio *
 * 			caso 3:
 * 				profesorMayor *
 * 			caso 4:
 * 				profesorMasJoven *
 * 			caso 5:
 * 				numProfesoresPorDebajoMedia *
 * 			caso 6:
 * 				numProfesoresPorEncimaMedia *
 * 		FinPara
 * 		Mostrar subMenuConsultas y validar opcion *
 * 	FinMientras
 * Fin
 */
public class DepartamentoDePersonal 
{
	public static void main(String[] args) 
	{
		GestionTxt gestion = new GestionTxt("profesores.txt");
		Validaciones validaciones = new Validaciones();
		int opcionMenuPrincipal, opcionSubMenu, ID;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		ProfesorImpl profesor;
		
		//Mostrar menu principal y validar opcion
		opcionMenuPrincipal = validaciones.mostrarMenuPrincipalYValidarOpcion();
		
		while(opcionMenuPrincipal != 4)
		{
			switch(opcionMenuPrincipal)
			{
				case 1:
		 			//insertarProfesor *
					profesor = validaciones.leerYValidarProfesor();
					gestion.insertarProfesor(profesor);				//TODO Mejorar esto (informar al usuario sobre si se insertó correctamente o no)
					
					break;
				case 2:
		 			//borrarProfesor *
					ID = entrada.nextInt();
					gestion.borrarProfesor(ID);						//TODO Mejorar esto (informar sobre si se borró correctamente o no)
					
					break;
				case 3:
		 			//subMenuConsultas *
					//Mostrar subMenuConsultas y validar opcion *
					opcionSubMenu = validaciones.mostrarSubMenuConsultasYValidarOpcion();
					
					while(opcionSubMenu != 7)
					{
						switch(opcionSubMenu)
						{
							case 1:
					 			//mostrarProfesores *
								gestion.mostrarProfesores();
								
								break;
							case 2:
								//edadPromedio *
					 			System.out.println("Edad promedio: " + gestion.edadPromedio());
					 			
								break;
							case 3:
								//profesorMayor *
								profesor = gestion.profesorMayor();
					 			System.out.println("Profesor mayor: " + profesor.getNombre() + "(" + profesor.getEdad() + " años)");
								break;
							case 4:
								//profesorMasJoven *
								profesor =gestion.profesorMasJoven();
								System.out.println("Profesor mas joven: " + profesor.getNombre() + "(" + profesor.getEdad() + " años)");
								break;
							case 5:
					 			//numProfesoresPorDebajoMedia *
					 			System.out.println("Numero de profesores con edad por debajo de la media: " + gestion.belowAverageTeachers());
					 			
								break;
							case 6:
								//numProfesoresPorEncimaMedia *
								System.out.println("Numero de profesores con edad por encima de la media: " + gestion.aboveAverageTeachers());
					 			
								break;
						}
					 	//Mostrar subMenuConsultas y validar opcion *
						opcionSubMenu = validaciones.mostrarSubMenuConsultasYValidarOpcion();
						
					}
					break;
			}
		 	//Mostrar menu principal y validar opcion
			opcionMenuPrincipal = validaciones.mostrarMenuPrincipalYValidarOpcion();
		}
	}
}
