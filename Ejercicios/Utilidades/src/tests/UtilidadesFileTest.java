package tests;
import clases.UtilidadesFile;
import java.io.File;

public class UtilidadesFileTest {

	public static void main(String[] args) 
	{
		UtilidadesFile utils = new UtilidadesFile();
		
		System.out.println("listarContenido():");
		utils.listarContenido(".");		//Ruta desde se está ejecutando.
		System.out.println();
		
		System.out.println("copiaFicheroTexto(\"fichero.txt\", \"nuevoFichero.txt\"):");
		utils.copiaFicheroTexto("fichero.txt", "nuevoFichero.txt");
		
		File fichero = new File("fichero.txt");
		System.out.println("fichero.exists(): " + fichero.exists());
		System.out.println("fichero.length(): " + fichero.length());
		
		File nuevoFichero = new File("nuevoFichero.txt");
		System.out.println("nuevoFichero.exists(): " + nuevoFichero.exists());
		System.out.println("nuevoFichero.length(): " + nuevoFichero.length());	
	}

}
