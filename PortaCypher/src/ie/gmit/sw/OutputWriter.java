package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
	//This method runs in O(n) time (or "linear time"), where n is the number of items. If the it has 10 items, we 
	//have to loop 10 times. If it has 1,000 items, we have to loop 1,000 times.
	public static void writeEncryption(String data, String key, String fileName) {
		 
	    BufferedReader reader = FileUrlParser.dataParser(data);	//reader

		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));	//writer
			
			String sentence = null;
			
			while((sentence = reader.readLine()) != null) {	//due to this while loop this method is considered to run in linear time
				String line = Cypher.Encrypt((sentence.toUpperCase().replaceAll("[^a-zA-Z]+","")), key);	//only takes alphabet letters, no special signs or/and spaces allowed
				
				writer.write(line + "\n");	//allowed for new line after each line to keep the same layout
			}//while
			
			reader.close();	//close reader
			writer.close();	//close writer
			
		}catch(IOException e){
			System.err.println("Input or Output error!");	//message in case of an error
		}//catch
		
	}// writeEncryption() 
}//OutputWriter
