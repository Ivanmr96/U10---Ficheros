import java.io.*;

public class ObjectWriter extends ObjectOutputStream
{
	public ObjectWriter(OutputStream out) throws IOException
    {
        super(out);
    }
    
    protected ObjectWriter() throws IOException, SecurityException
    {
        super();
    }
    
    protected void writeStreamHeader() throws IOException
    {
    }
}
