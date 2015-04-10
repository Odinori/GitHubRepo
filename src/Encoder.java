import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;

public class Encoder {
	
	private File inputFile;
	
	public Encoder(String fileName) {
		inputFile = new File(fileName);
	}
	
	public void Write(String inputString) throws FileNotFoundException, IOException, UnsupportedEncodingException
	{
        OutputStream outputStream = new FileOutputStream( inputFile );
        OutputStream wrappedOS = Base64.getEncoder().wrap( outputStream );
        wrappedOS.write( inputString.getBytes( "utf-8" ) );
	}
	
	public ArrayList<String> Read() throws FileNotFoundException, IOException, UnsupportedEncodingException
	{
		ArrayList<String> outStrings = new ArrayList<String>();
        InputStream inputStream = new FileInputStream( inputFile );
        InputStream unWrappedIS = Base64.getDecoder().wrap( inputStream );
        BufferedReader reader = new BufferedReader(new InputStreamReader(unWrappedIS));
        String line;
        while ((line = reader.readLine()) != null) {
        	outStrings.add(line);
        }
		return outStrings;
	}
}