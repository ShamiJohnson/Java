//Reader- delimits read line and files into hashtable
import java.io.*;
public class Reader
{
	private BufferedReader buffRead;
	private FileReader fileRead;
	
	public Reader(String filename)
	{
		try
		{
			fileRead = new FileReader(filename);
			buffRead = new BufferedReader(fileRead);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String[] ReadLine()
	{	// Reads a line from the file
		String line = new String("");
		try {
			line = buffRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (line != null)
		{
			int commentDot = line.indexOf(".");
			
			if (commentDot != -1)
			{
				line = line.substring(0, commentDot);
			}
			
			String[] add = line.split ("\\s+");
			
			return add;
		}
		else
		{
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
}