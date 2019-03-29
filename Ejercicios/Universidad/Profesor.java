import java.io.Serializable; 
public class Profesor implements Serializable
{
	private int ID;
	private String nombre;
	private char sexo;
	private int edad;
	
	public Profesor(int ID, String nombre, char sexo, int edad)
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
	
	@Override
	public String toString()
	{
		return "ID: " + getID() +
			   "\nNombre: " + getNombre() + 
			   "\nSexo: " + getSexo() + 
			   "\nEdad: " + getEdad();
	}
	
	@Override
	public int hashCode()
	{
		return (getNombre().hashCode() * 11) + ((int)getSexo() * 3) * (getEdad() * 7);
	}
}
