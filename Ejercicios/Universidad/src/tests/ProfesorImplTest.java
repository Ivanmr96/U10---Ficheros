package tests;

import clases.basicas.ProfesorImpl;

public class ProfesorImplTest {

	public static void main(String[] args) 
	{
		ProfesorImpl porDefecto = new ProfesorImpl();
		ProfesorImpl conParametros = new ProfesorImpl(5, "Iván", 'H', 23);
		ProfesorImpl deCopia = new ProfesorImpl(conParametros);
		
		//métodos get
		System.out.println("porDefecto.getID(): " + porDefecto.getID());
		System.out.println("conParametros.getNombre(): " + conParametros.getNombre());
		System.out.println("deCopia.getSexo(): " + deCopia.getSexo());
		System.out.println("porDefecto.getEdad(): " + porDefecto.getEdad());
		
		System.out.println("-----------------------------------------");
		
		//métodos set
		System.out.println("conParametros.setEdad(45)");
		System.out.println("ANTES -> " + conParametros.getEdad());
		conParametros.setEdad(45);
		System.out.println("DESPUES -> " + conParametros.getEdad());
		
		System.out.println("-----------------------------------------");
		
		System.out.println("deCopia.setNombre(\"Sara\")");
		System.out.println("ANTES -> " + deCopia.getNombre());
		deCopia.setNombre("Sara");
		System.out.println("DESPUES -> " + deCopia.getNombre());
		
		System.out.println("-----------------------------------------");
		
		System.out.println("porDefecto.setSexo('H')");
		System.out.println("ANTES -> " + porDefecto.getSexo());
		porDefecto.setSexo('H');
		System.out.println("DESPUES -> " + porDefecto.getSexo());
		
		System.out.println("-----------------------------------------");
		
		//metodos añadidos/sobreescritos
		System.out.println("conParametros.toString():");
		System.out.println(conParametros.toString());
		
		System.out.println("-----------------------------------------");
		
		System.out.println("deCopia.hashCode(): " + deCopia.hashCode());
		
		System.out.println("-----------------------------------------");
		
		System.out.println("ProfesorImpl clonado = conParametros.clone()");
		ProfesorImpl clonado = conParametros.clone();
		
		System.out.println("conParametros.toString():");
		System.out.println(conParametros.toString());
		
		System.out.println("clonado.toString():");
		System.out.println(clonado.toString());
	}

}
