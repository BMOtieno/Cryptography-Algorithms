package AffineCipher;

import java.math.BigInteger;
import java.util.Scanner;

public class AffineCipher {
	/*
	 * A program that implements the Affine Cipher
	 * 
	 * @param String input that is gotten from the user
	 * @return encrypted/ decrypted text
	 * @author Brian Otieno Odhiambo
	 * 
	 * */
	
	private static int firstKey = 5;
	private static int secondKey = 19;
	private static int module = 26;
	
	//method to encrypt the text
	public static String encrypt(String input) {
		
		  StringBuilder builder = new StringBuilder();
		    for (int i = 0; i < input.length(); i++) {
		        char character = input.charAt(i);
		        if (Character.isLetter(character)) {
		            character = (char) ((firstKey * (character - 'a') + secondKey) % module + 'a');
		        }
		        builder.append(character);
		    }
		    return builder.toString();
	}
	
	//method to decrypt the text
	public static String decrypt(String input) {
		
		 StringBuilder builder = new StringBuilder();
		    // compute firstKey^-1 also known as the "modular inverse"
		    BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));
		    // perform actual decryption
		    for (int i = 0; i < input.length(); i++) {
		        char character = input.charAt(i);
		        if (Character.isLetter(character)) {
		            int decoded = inverse.intValue() * (character - 'a' - secondKey + module);
		            character = (char) (decoded % module + 'a');
		        }
		        builder.append(character);
		    }
		    return builder.toString();
	}
	
	//void method to create a prompt to the user to enter a text
	public static void userInput() {
		
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Welcome to Brian's Affine Cipher");
			System.out.println("Enter your text: ");
			String input = scanner.next();
			String cipher = encrypt(input);
		    String deciphered = decrypt(cipher);
		    System.out.println("Input:    " + input);
		    System.out.println("Encrypted: " + cipher);
		    System.out.println("Decrypted: " + deciphered);
		}
	}
	
	public static void main(String[] args) {
		//call to the userInput method
		userInput();  
	}
}
