package clases.utilidad;

import java.io.*;


//Clase necesaria para poder usar ObjectOutputStream sin que escriba cabecera.
class ObjectWriter extends ObjectOutputStream
{
	public ObjectWriter(OutputStream out) throws IOException
    {
        super(out);
    }
    
    protected ObjectWriter() throws IOException, SecurityException
    {
        super();
    }
    
    protected void writeStreamHeader() throws IOException{}
}

