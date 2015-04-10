<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
=======
>>>>>>> origin/master
import java.util.ArrayList;
import java.util.List;


public class BackEnd 
{
	
	//jackson
	public static List<String> getMessages(String username)
	{
<<<<<<< HEAD
		List<String> messages = new ArrayList<String>();
		File file = new File(username);
		try 
		{
			FileReader fileReader = new FileReader(file);
		} 
		catch (FileNotFoundException e) {}
		
		
		return messages;
=======
		
		return null;
>>>>>>> origin/master
	}
	
	public void addMessage(String username, String msg)
	{
		Encoder encoder(username);
		encoder.write(msg);
	}

	public List<String> getUsers()
	{
		return null;
	}
	
}
