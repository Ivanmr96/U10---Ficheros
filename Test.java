
public class Test
{
	public static void main(String[] args)
	{
		Writer writer = new Writer();
		Reader reader = new Reader();
		
		Persona persona = new Persona("nombre", 21, "DNI xd", 'M', 74.1, 1.80);
		Persona persona2 = new Persona("nombre2", 1, "DNxkI2", 'H', 2.1, 1.23);
		Persona persona3 = new Persona("nom11bre", 2, "D4432", 'H', 74.2, 1.75);
		Persona persona4 = new Persona("nJESU", 31, "Dwww", 'M', 72.1, 1.1);
		Persona persona5 = new Persona("lluy", 55, "DNd", 'H', 711, 1);
		Persona persona6 = new Persona("buat", 19, " xd", 'M', 84.1, 555);
		
			writer.insertarObjeto(persona, "Personas2.txt");

		/*
		for(int i = 0 ; i < array.length ; i++)
		{
			persona = (Persona)reader.leerObjeto("Personas.txt");
			System.out.println(persona.toString());
		}*/

	}
}
