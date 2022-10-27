package Relative_Frequency;

import java.util.Scanner;
/****************************************************************************************/   
/* The freqCount class counts the relative frequencies of different letters in a word or
sentence which is provided as input by a user. 
*/
/****************************************************************************************/
public class RelativeFrequency {
	/*
	 * @author Brian Otieno Odhiambo.
	 * 
	 * */
	
	public static void main(String[] args) { 
		
		int pos = 0;
		Scanner in = new Scanner(System.in);
		
		//Prompts the user for an input
		System.out.println("\nEnter a word/sentence:");				
		String str = in.nextLine();
		
		//Converts the input to lower case
		str = str.toLowerCase();
		
		//Below array will hold the count of each letter
		int[] count = new int[26];
	
		for (int i = 0; i < str.length(); i++) { 
			
			char ch = str.charAt(i);
			if(ch != ' ') { //Excludes the spaces from consideration 
				pos = (int)ch - 97;
				//System.out.println(pos);
				count[pos]++;
			}	
		}
		int sum = 0;
		for (int i = 0; i < count.length; i++) {
		//if(count[i] != 0)//Shows letters with non-zero counts
		//System.out.printf("\nCount of %c = %d", (char)(i + 97),count[i]);
		System.out.printf("\nCount of %c = %f", (char)(i + 97),(double)count[i]/str.length());
		}
		
		System.out.println("\n");
	}
}
