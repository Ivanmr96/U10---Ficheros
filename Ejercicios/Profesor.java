import java.io.Serializable; 
public class Profesor implements Serializable
{
	private String nombre;
	private char sexo;
	private int edad;
	
	public Profesor(String nombre, char sexo, int edad)
	{
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}
	
	public String getNombre() { return this.nombre; }
	public char getSexo() { return this.sexo; }
	public int getEdad() { return this.edad; }
}
