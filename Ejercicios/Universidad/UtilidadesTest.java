//package tests;
import java.awt.Color;
import java.awt.Point;
import java.util.GregorianCalendar;

import clases.Utilidades;

public class UtilidadesTest {

	public static void main(String[] args) 
	{
		Utilidades util = new Utilidades();
		
		Color color;
		
		GregorianCalendar calendario = new GregorianCalendar();
		
		Point punto = new Point();
		
		for(int i = 0 ; i < 200 ; i++)
		{
			color = new Color(i, i, i);
			util.insertarObjeto(color, "fichero.txt");
		}
		
		util.mostrarFicheroObjetos("fichero.txt");
	}

}
