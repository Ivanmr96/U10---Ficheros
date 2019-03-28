package tests;
import java.awt.Color;

import clases.Utilidades;

public class UtilidadesTest {

	public static void main(String[] args) 
	{
		Utilidades util = new Utilidades();
		
		Color color = new Color(25,25,25);
		
		util.insertarObjeto(color, "fichero.txt");
		
		util.mostrarFicheroObjetos("fichero.txt");
	}

}
