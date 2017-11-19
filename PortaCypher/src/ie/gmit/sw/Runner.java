package ie.gmit.sw;

import java.net.MalformedURLException;
import java.util.Scanner;


public class Runner {
	//Local Variables
	private static String key = "DATASTRUCTURESANDALGORITHMS";
	private static String fileOrUrl = "trial.txt";
	private static Scanner input = new Scanner(System.in);
	
	//Main
	public static void main(String[] args) throws MalformedURLException {
		menu();	//menu
		runningTime();	//to check running time

	}//main
	
	//Menu
	public static void menu() {
		//Variables
		int option = 0;	//initialize
		
		menuOptions();	//displays different options
		
		do {
			//User Input
			System.out.print("\nYour Option (5 for menu, -1 to exit): ");	//-1 to exit, 5 to display menu again
			option = input.nextInt();
			
			switch(option) {
				case 1:
					//Parse File or URL
					System.out.print("\tEnter File(allow for '.txt' at the end of file name) or URL: ");
					fileOrUrl = input.next();
					
					FileUrlParser.dataParser(fileOrUrl);
					System.out.println("\t"+ fileOrUrl +" saved in memory!");
					break;
				case 2:
					//User Choice for Key
					System.out.print("\tEnter Keyword: ");
					key =  input.next();
					
					System.out.println("\t"+ key +" set as encryption/decryption key!");	//message for the user
					break;
				case 3:
					//Encrypt
					OutputWriter.writeEncryption(fileOrUrl, key, "Encrypted.txt");	//encrypts data
					System.out.println("\t"+ fileOrUrl +" data has been Encrypted!");	//message for the user
					break;
				case 4:
					//Decrypt
					OutputWriter.writeEncryption("Encrypted.txt", key,"Decrypted.txt");	//decrypts previously encrypted data
					System.out.println("\t"+ "Encrypted.txt" +" data has been Decrypted!");	//message for the user
					break;
				case 5:
					//Menu Options
					menuOptions();	//displays the menu again
					break;
				case -1:
					//Exits the loop
					break;
				default:
					//Default option
					System.out.println("This option doesn't exist!");
			}//switch
		
		} while(option != -1);	//-1 terminates the loop
	}//menu()
	
	//Menu options
	//This function runs in O(1) time (or "constant time") relative to its input. The input we 
	//could be printing 1 item or 1,000 items, but this function would still just require one "step."
	private static void menuOptions() {
		System.out.println("1 - Parse File or URL");
		System.out.println("2 - Enter Keyword");
		System.out.println("3 - Encrypt");
		System.out.println("4 - Decrypt");
		System.out.println("5 - Display Menu");
		System.out.println("-1 - Exit");
	}//menuOptions()
	
	//Shows Running Time of Encryption and Decryption
	//This function runs in O(1) time (or "constant time") relative to its input. The input we 
	//could be printing 1 item or 1,000 items, but this function would still just require one "step."
	private static void runningTime() {
		int startTime = (int)System.currentTimeMillis();	//gets current system time
		
		OutputWriter.writeEncryption(fileOrUrl, key, "Encrypted.txt");	//encrypts
		OutputWriter.writeEncryption("Encrypted.txt", key,"Decrypted.txt");	//decrypts
		
		//Prints the time it took to encrypt and decrypt file or URL
		System.out.println("Time: " + ((int)System.currentTimeMillis() - startTime) + " Millis");
	}//testRun()

}//runner
