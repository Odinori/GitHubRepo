<<<<<<< HEAD
import java.util.*;

public class BackEnd {

	Encoder enc = new Encoder("messages.bin");

	HashMap<String, List<String>> messages;

	public BackEnd() {
		this.messages = new HashMap<String, List<String>>();
		
		List<String> rawMsg = this.enc.read();
		
		if(rawMsg != null) {
			for(String msg : rawMsg) {
				String[] components = msg.split("\\t");
				
				if(this.messages.containsKey(components[0])) {
					this.messages.get(components[0]).add(components[1]);
				} else {
					ArrayList<String> a = new ArrayList<String>();
					a.add(components[1]);
					
					this.messages.put(components[0], a);
				}
			}
		}
	}

	public List<String> getMessages(String username) {
		return this.messages.get(username);
	}
	
	public void addMessage(String username, String msg) {
		if(this.messages.containsKey(username)) {
			this.messages.get(username).add(msg);
		} else {
			ArrayList<String> a = new ArrayList<String>();
			a.add(msg);
			this.messages.put(username, a);
		}
		
		this.save();
	}

	public void removeMessage(String username, String msg) {
		this.messages.get(username).remove(msg);

		if(this.messages.get(username).isEmpty()) {
			this.messages.remove(username);
		}
		
		this.save();
	}

	public List<String> getUsers() {
		Set<String> keys = this.messages.keySet();
		ArrayList<String> list = new ArrayList<String>(keys.size());
		
		for (String string : keys) {
			list.add(string);
		}
		
		return list;
	}

	private String convertToString() {
		String s = "";

		for (String user : this.getUsers()) {
			for (String message : this.getMessages(user)) {
				String string = user + "\t" + message;
				s += string + "\n";
			}
		}
		
		return s;
	}

	private void save() {
		String s = convertToString();
		this.enc.write(s);
	}
}
/*import java.io.File;
 
=======
<<<<<<< HEAD
import java.io.File;
>>>>>>> origin/master
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
	
	public static void addMessage(String username, String msg)
	{
		Encoder encoder(username);
		encoder.write(msg);
	}

	public List<String> getUsers()
	{
		return null;
	}
	
}
