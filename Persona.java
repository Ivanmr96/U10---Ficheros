/* ESTUDIO DE INTERFAZ
 * 
 * -Propiedades relevantes:
 * 	-> nombre
 * 	-> edad
 * 	-> DNI
 * 	-> sexo
 * 	-> peso
 * 	-> altura
 *  
 * -
 * 	-> String nombre
 * 		+ ¿Consultable?: Sí
 * 		+ ¿Modificable?: No
 * 	-> int edad
 * 		+ ¿Consultable?: Sí
 * 		+ ¿Modificable?: Sí
 * 	-> String DNI
 * 		+ ¿Consultable?: Sí
 * 		+ ¿Modificable?: No
 * 	-> char sexo
 * 		+ ¿Consultable?: Sí
 * 		+ ¿Modificable?: No
 * 	-> double peso
 * 		+ ¿Consultable?: Sí
 * 		+ ¿Modificable?: Sí
 * 	-> int altura
 * 		+ ¿Consultable?: Sí
 * 		+ ¿Modificable?: Sí
 * 
 * - Propiedades derivadas: No hay
 * 
 * - Propiedades compartidas: No hay
 * 
 * - Restricciones:
 * 		-> edad: No puede ser menor que 0
 * 		-> sexo: tiene que ser 'H' o 'M'
 * 		-> peso: No puede ser menor que 0
 * 		-> altura: No puede ser menor que 0
 * 
 * - Otros métodos necesarios:
 * 		-> IMC(): Calcula el Indice de Masa Corporal para saber si una persona está en su peso ideal
 * 		-> esMayorDeEdad(): Para saber si la persona es mayor de edad o no
 * 
 * INTERFAZ
 * 
 * 		String getNombre();
 * 		int getEdad();
 * 		String getDNI();
 * 		char getSexo();
 * 		double getPeso();
 * 		int getAltura();
 * 
 * 		void setEdad(int edad);
 * 		void setPeso(double peso);
 * 		void setAltura(int altura);
 * 
 * 		double IMC();
 * 		int pesoIdeal();
 * 		boolean esMayorDeEdad();
 */
 import java.io.*;
public class Persona implements Serializable
{
	private String 	nombre;
	private int 	edad;
	private String 	DNI;
	private char 	sexo;
	private double 	peso;
	private double 	altura;
	
	public Persona()
	{
		this.nombre = "";
		this.edad 	= 0;
		this.DNI 	= "00000000A";
		this.sexo 	= 'H';
		this.peso 	= 0.0;
		this.altura = 0;
	}
	
	public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura)
	{
		this.nombre = nombre;
		this.edad 	= edad;
		this.DNI 	= DNI;
		this.sexo 	= sexo;
		this.peso 	= peso;
		this.altura = altura;
	}
	
	public Persona(Persona persona)
	{
		this.nombre = persona.nombre;
		this.edad 	= persona.edad;
		this.DNI 	= persona.DNI;
		this.sexo	= persona.sexo;
		this.peso 	= persona.peso;
		this.altura = persona.altura;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getEdad()
	{
		return this.edad;
	}
	
	public String getDNI()
	{
		return this.DNI;
	}
	
	public char getSexo()
	{
		return this.sexo;
	}
	
	public double getPeso()
	{
		return this.peso;
	}
	
	public double getAltura()
	{
		return this.altura;
	}

	public void setEdad(int edad)
	{
		this.edad = edad;
	}
	
	public void setPeso(double peso)
	{
		this.peso = peso;
	}
	
	public void setAltura(double altura)
	{
		this.altura = altura;
	}

	public double IMC()
	{
		return this.peso / (this.altura * this.altura);
	}
	
	public int pesoIdeal()
	{
		double IMC;
		int ret;
		
		IMC = this.IMC();
		
		if (IMC < 18.5)
			ret = -1;
		else if ( IMC >= 30.0)
			ret = 1;
		else
			ret = 0;
			
		return ret;
	}
	
	public boolean esMayorDeEdad()
	{
		boolean ret = false;
		
		if (this.edad >= 18)
			ret = true;
			
		return ret;
	}

	public boolean equals(Persona persona)
	{
		boolean ret;
		
		boolean nombre 	= this.nombre == persona.nombre;
		boolean edad 	= this.edad == persona.edad;
		boolean DNI 	= this.DNI == persona.DNI;
		boolean sexo 	= this.sexo == persona.sexo;
		boolean peso 	= this.peso == persona.peso;
		boolean altura 	= this.altura == persona.altura;
		
		if (nombre && edad && DNI && sexo && peso && altura)
			ret = true;
		else
			ret = false;
		
		return ret;
	}
	
	public String toString()
	{
		return "" + "Nombre: " 		+ this.nombre + 
					"\nEdad: " 		+ this.edad + 
					"\nDNI: " 		+ this.DNI + 
					"\nSexo: " 		+ this.sexo +
					"\nPeso: " 		+ this.peso +
					"\nAltura: " 	+ this.altura;			//"Representación como cadena: todos los datos en líneas sucesivas"
	}
	
	public int compareToPeso(Persona persona)
	{
		int ret = 0;
		
		if(this.getPeso() < persona.getPeso())
			ret = -1;
		else if (this.getPeso() > persona.getPeso())
			ret = 1;
		
		return ret;
	}
	public int compareToAltura(Persona persona)
	{
		int ret = 0;
		
		if(this.getPeso() < persona.getAltura())
			ret = -1;
		else if (this.getPeso() > persona.getAltura())
			ret = 1;
		
		return ret;
	}
}
