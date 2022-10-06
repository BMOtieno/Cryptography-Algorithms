package Relative_Frequency;

import java.util.Scanner;

public class RelativeFrequency {
	/*
	 * A program that computes the relative frequencies of letters in
	 * a given piece of text.
	 * 
	 * @param String input from the user, letter in the input text(character)
	 * @return the count of each letter in the string
	 * @author Brian Otieno Odhiambo.
	 * 
	 * */
	
	public static int countLetter(String input, char ofInput) {
		
		int count = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ofInput) {
				count++;
			}
		}
		return count;
	}
	
	//method to compute the relative frequency
	public static void getRelativeFrequency() {
		//wrap your scanner object in a try statement as an efficient way to close resources
		try(Scanner scanner = new Scanner(System.in)){	
			System.out.println("Enter your text to get the relative frequency for each letter");
			String response = scanner.next();
			
			//type cast the input string length to a double
			double length = response.length();
			
			//count the occurrence of each letter in the text and divide it by it's length
			for(int j = 0; j < length; j++) {
				System.out.println("Letter: " + response.charAt(j) +" Relative Frequency: " + ((countLetter(response, response.charAt(j)))/length)*100 + "%");
			}	
		}
	}
	
	public static void main(String[] args) {
		//call to the getRelativeFrequency method
		getRelativeFrequency();
	}
}
