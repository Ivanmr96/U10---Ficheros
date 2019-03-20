public class Fichero
{
	//ORDENACIÓN HÍBRIDA
	/* INTERFAZ
	 * Comentario: Ordena el fichero
	 * Prototipo: ordenarFichero(Fichero fichero)
	 * Entrada: Un fichero
	 * Precondiciones: El fichero no puede estar vacío
	 * Salida: Un fichero
	 * Postcondiciones: Asociado al nombre devuelve el fichero ordenado.
	 */
	/* PSEUDOCODIGO
	 * Inicio
	 * 		Calcular numero de registros del fichero
	 * 		Declarar e inicializar array
	 * 		Volcar el fichero en el array
	 * 		Ordenar array
	 * 		Volar el array en el fichero
	 * Fin
	 */
	 
	 //BUSQUEDA SECUENCIAL
	 /* INTERFAZ
	  * Comentario: Busca un registro especificado en un fichero
	  * Prototipo: buscarRegistro(Fichero fichero, Registro registro)
	  * Entrada: Un fichero y el registro que se desea buscar
	  * Precondiciones: El fichero no puede estar vacio
	  * Salida: 
	  * Postcondiciones:
	  */ 
	 /* PSEUDOCODIGO
	  * Inicio
	  * 	Abrir fichero para leer
	  * 	Leer registro del fichero
	  * 	Mientras (no sea fin de fichero O no se haya encontrado el registro)
	  * 		Si no es el registro a buscar
	  * 			Leer registro del fichero
	  * 		FinSi
	  * 	FinMientras
	  * 	Cerrar el fichero
	  * Fin
	  */
	  
	  //PARTICIÓN
	  /* INTERFAZ
	   * Comentario: Divide un fichero en dos, copiando alternativamente en uno y otro, secuencias de registros de longitud N
	   * Prototipo: partirEnSecuencias()
	   * Entrada: 
	   * 		-> El fichero que se desea partir
	   * 		-> Un fichero donde se guardará una parte del fichero original
	   * 		-> Otro fichero donde se guardará la otra parte del fichero original
	   * 		-> un entero para la longitud de las secuencias en las que se partirá el fichero.
	   * Precondiciones:
	   * 		-> El fichero que se desea partir no puede estar vacio
	   * 		-> El entero para la longitud debe ser mayor que 0
	   * Salidas:
	   * 
	   */
}
