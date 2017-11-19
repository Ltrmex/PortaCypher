package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FileUrlParser {
	//This function runs in O(1) time (or "constant time") relative to its input. The input we 
	//could be printing 1 item or 1,000 items, but this function would still just require one "step."
	public static BufferedReader dataParser(String data) {
		
		BufferedReader reader = null;
		
		try{
			
			if(data.contains("www.") || data.contains("http.")) {	//check if parsed string is an URL
				URL url = new URL(data);
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
			}//if
			
			else
				reader = new BufferedReader(new FileReader(data));	//read data
			
		}catch(IOException e) {
			System.err.println("Invalid File or URL!");	//message in case of an error
		}
		return reader;
	}//dataParser()
	
}//FileUrlParser
