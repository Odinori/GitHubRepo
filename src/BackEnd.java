import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class BackEnd {

	Encoder enc = new Encoder("messages.bin");

	HashMap<String, List<String>> messages;

	public BackEnd() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		this.messages = new HashMap<String, List<String>>();
		
		ArrayList<String> rawMsg = this.enc.Read();
		
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
	
	public void addMessage(String username, String msg) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		if(this.messages.containsKey(username)) {
			this.messages.get(username).add(msg);
		} else {
			ArrayList<String> a = new ArrayList<String>();
			a.add(msg);
			this.messages.put(username, a);
		}
		
		this.save();
	}

	public void removeMessage(String username, String msg) throws FileNotFoundException, UnsupportedEncodingException, IOException {
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

	private void save() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		String s = convertToString();
		this.enc.Write(s);
	}
}