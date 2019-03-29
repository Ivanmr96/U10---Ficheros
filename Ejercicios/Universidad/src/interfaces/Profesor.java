/* ESTUDIO DE INTERFAZ
 * 
 * Propiedades básicas:
 * 		-> ID: int, consultable
 * 		-> nombre: String, consultable, modificable
 * 		-> sexo: char, consultable, modificable
 * 		-> edad: int, consultable, modificable
 * 
 * Propieades derivadas: No hay
 * Propiedadaes compartidas: No hay
 */

/* INTERFAZ
 * 
 * public int getID();
 * 
 * public String getNombre();
 * public void setNombre(String nombre);
 * 
 * public char getSexo();
 * public void setSexo(char sexo);
 * 
 * public int getEdad();
 * public void setEdad(int edad);
 */

package interfaces;

public interface Profesor 
{
	public int getID();
	 
	public String getNombre();
	public void setNombre(String nombre);
	 
	public char getSexo();
	public void setSexo(char sexo);
	 
	public int getEdad();
	public void setEdad(int edad);
}
