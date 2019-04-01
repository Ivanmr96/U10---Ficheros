package clases.basicas;

import java.io.Serializable;

import interfaces.Profesor;

public class ProfesorImpl implements Serializable, Profesor, Cloneable
{
	private int ID;
	private String nombre;
	private char sexo;
	private int edad;
	
	public ProfesorImpl()
	{
		this.ID = 0;
		this.nombre = "";
		this.sexo = ' ';
		this.edad = 0;
	}
	
	public ProfesorImpl(int ID, String nombre, char sexo, int edad)
	{
		this.ID = ID;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}
	
	public ProfesorImpl(ProfesorImpl otro)
	{
		this.ID = otro.getID();
		this.nombre = otro.getNombre();
		this.sexo = otro.getSexo();
		this.edad = otro.getEdad();
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
			   "\n" + getNombre() + 
			   "\n" + getSexo() + 
			   "\n" + getEdad();
	}
	
	@Override
	public int hashCode()
	{
		return (getNombre().hashCode() * 11) + ((int)getSexo() * 3) * (getEdad() * 7);
	}
	
	@Override
	public ProfesorImpl clone()
	{
		ProfesorImpl copia = null;
		
		try
		{
			copia = (ProfesorImpl)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e);
		}
		
		return copia;
	}
}
