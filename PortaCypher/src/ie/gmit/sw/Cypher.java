package ie.gmit.sw;

public class Cypher {
	//This function runs in O(n) time (or "linear time"), where n is the number of items. If the it has 10 items, we 
	//have to loop 10 times. If it has 1,000 items, we have to loop 1,000 times.
	public static String Encrypt(String contents, String key) {
		
		key = key.toUpperCase();	//key must be upper case
		char[] k = key.toCharArray();	//change string into char array to allow check of each char
	    String ciphertext = "";	//here encrypted string will be kept
	    
	    //tableau needed for encrypting data
        char[][] tableau = {
        		{'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'},
        		{'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'M', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'},
        		{'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'L', 'M', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'},
        		{'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'K', 'L', 'M', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'},
        		{'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'J', 'K', 'L', 'M', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'},
        		{'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'I', 'J', 'K', 'L', 'M', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'},
        		{'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'H', 'I', 'J', 'K', 'L', 'M', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
        		{'U', 'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'A', 'B', 'C', 'D', 'E', 'F'},
        		{'V', 'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'A', 'B', 'C', 'D', 'E'},
        		{'W', 'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'A', 'B', 'C', 'D'},
        		{'X', 'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'A', 'B', 'C'},
        		{'Y', 'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'A', 'B'},
        		{'Z', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'A'}
        };
        
	    for(int i = 0; i < contents.length(); i++) { //for loop means that it's going to be linear
	            int j = i%k.length;

				//Subtract the 65, which is the ASCII code of 'A'
	            //so, letter.charCodeAt(0)-65 will give you the sequence of each alphabet letter
	            if ((k[j] == 'A') || (k[j] == 'B')) //determines which char of key we're at
	            	ciphertext += tableau[0][contents.charAt(i)-65];	//determines where to go in each row
	            else if ((k[j] == 'C') || (k[j] == 'D')) 
	            	ciphertext += tableau[1][contents.charAt(i)-65];
	            else if ((k[j] == 'E') || (k[j] == 'F')) 
	            	ciphertext += tableau[2][contents.charAt(i)-65];
	            else if ((k[j] == 'G') || (k[j] == 'H')) 
	            	ciphertext += tableau[3][contents.charAt(i)-65];
	            else if ((k[j] == 'I') || (k[j] == 'J')) 
	            	ciphertext += tableau[4][contents.charAt(i)-65];
	            else if ((k[j] == 'K') || (k[j] == 'L')) 
	            	ciphertext += tableau[5][contents.charAt(i)-65];
	            else if ((k[j] == 'M') || (k[j] == 'N')) 
	            	ciphertext += tableau[6][contents.charAt(i)-65];
	            else if ((k[j] == 'O') || (k[j] == 'P')) 
	            	ciphertext += tableau[7][contents.charAt(i)-65];
	            else if ((k[j] == 'Q') || (k[j] == 'R')) 
	            	ciphertext += tableau[8][contents.charAt(i)-65];
	            else if ((k[j] == 'S') || (k[j] == 'T')) 
	            	ciphertext += tableau[9][contents.charAt(i)-65];
	            else if ((k[j] == 'U') || (k[j] == 'V')) 
	            	ciphertext += tableau[10][contents.charAt(i)-65];
	            else if ((k[j] == 'W') || (k[j] == 'X')) 
	            	ciphertext += tableau[11][contents.charAt(i)-65];
	            else if ((k[j] == 'Y') || (k[j] == 'Z')) 
	            	ciphertext += tableau[12][contents.charAt(i)-65];
	    }//for
	    return(ciphertext); //return encrypted string
	}//Encrypt
}//Runner