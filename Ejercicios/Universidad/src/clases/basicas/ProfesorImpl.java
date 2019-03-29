package clases.basicas;

import java.io.Serializable;

import interfaces.Profesor;

public class ProfesorImpl implements Serializable, Profesor
{
	private int ID;
	private String nombre;
	private char sexo;
	private int edad;
	
	public ProfesorImpl(int ID, String nombre, char sexo, int edad)
	{
		this.ID = ID;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}
	
	public int getID() { return this.ID; }
	public String getNombre() { return this.nombre; }
	public char getSexo() { return this.sexo; }
	public int getEdad() { return this.edad; }
	
	public void setNombre(String nombre) { this.nombre = nombre; }

	public void setSexo(char sexo) { this.sexo = sexo; }

	public void setEdad(int edad) { this.edad = edad; }
	
	@Override
	public String toString()
	{
		return "" + getID() +
			   " " + getNombre() + 
			   " " + getSexo() + 
			   " " + getEdad();
	}
	
	@Override
	public int hashCode()
	{
		return (getNombre().hashCode() * 11) + ((int)getSexo() * 3) * (getEdad() * 7);
	}
}
