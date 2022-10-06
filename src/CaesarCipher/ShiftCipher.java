package CaesarCipher;

import java.util.Scanner;

public class ShiftCipher {
	/* 
	 * This is a program that uses Caesar's Cipher to encrypt and decrypt a text.
	 * 
	 * To decrypt a text make sure you run the text in RelativeFrequency program
	 * to determine the most frequent letter.
	 * 
	 * Identify the position of that letter in the alphabet using zero based indexing
	 * i.e A = 0, B =1, C= 2, D =3...
	 * 
	 * Use this position as your shift key and plug it in the method calls
	 * 
	 * @author Brian Otieno Odhiambo
	 * @return the output of the Cipher Operation
	 * 
	 * 
	 * */
	
	public static final String lettersOfTheAlphabet = "abcdefghijklmnopqrstuvwxyz";
	
	//method to get the user input
	public static void userPrompt() {
		
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Welcome to your Shift Cipher encryption/decryption program");
			System.out.println("1.To Encrypt Text");
			System.out.println("2. To Decrypt Text");
			System.out.println("3. Enter 'exit' to exit the program");
			
			while(true) {
				System.out.println("Enter your text: ");
				String userInput = scanner.next();
				System.out.println("Select action: pick either option 1, option 2 or option 3");
				int inputInt = scanner.nextInt();
				
				switch(inputInt) {
				case 1:
					encryption(userInput, 19);
					break;
				case 2:
					decryption(userInput, 19);
					break;
				case 3:
					System.out.println("You've successfully exited the program. Goodbye!");
					System.exit(0);
				}
				
			}
			
		}
		
	}
	
	//method to encrypt text
	public static void encryption(String inputText, int shiftKey) {
		inputText= inputText.toLowerCase();
		String cipherText = "";
		for(int i= 0; i < inputText.length(); i++) {
			int charPosition = lettersOfTheAlphabet.indexOf(inputText.charAt(i));
			int keyValue = (shiftKey + charPosition) % 26;
			char replaceValue = lettersOfTheAlphabet.charAt(keyValue);
			cipherText += replaceValue;
		}
		System.out.println("The encrypted text is: " + cipherText);
	}
	
	//method to decrypt text
	public static void decryption(String cipherText, int shiftKey) {
		cipherText = cipherText.toLowerCase();
		String hiddenText= "";
		for(int i= 0; i < cipherText.length(); i++) {
			int positionOfChar = lettersOfTheAlphabet.indexOf(cipherText.charAt(i));
			int keyValue = (shiftKey + positionOfChar) % 26;
			if(keyValue < 0) {
				keyValue += lettersOfTheAlphabet.length();		
			}
			char replaceValue = lettersOfTheAlphabet.charAt(keyValue);
			hiddenText += replaceValue;
		}
		System.out.println("The decrypted text is: " + hiddenText);
	}
	
	public static void main(String[] args) {
		//call to the userPrompt method
		userPrompt();	
	}

}
