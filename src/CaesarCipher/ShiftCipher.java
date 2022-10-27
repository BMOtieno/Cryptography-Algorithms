package CaesarCipher;

import java.util.Scanner;
/****************************************************************************************/   
/* The ShiftCipher class implements working of a shift cipher. Every letter in the 
plaintext message is shifted by the specified shift to obtain the corresponding letter in
the ciphertext.

Assumptions:

		-	We ignore the spaces and punctuations in the plaintext.
			
		-	We do not differentiate between uppercase and lowercase letters in the
			plaintext.
		
/****************************************************************************************/

public class ShiftCipher {
	/* 
	 * 
	 * @author Brian Otieno Odhiambo
	 *  
	 * */
	
private int Shift;
	
	public ShiftCipher(int s) {
		Shift = s;
	}

	public String Encrypt(String str) { 
		
		str = str.toLowerCase();

		char[] CipherText = new char[str.length()];
				
		for (int i = 0; i < str.length(); i++) { 
			int temp_s = (int) str.charAt(i);
			temp_s = temp_s - 97;
			int y  = mod26(temp_s + Shift); 
			CipherText[i] = (char)(y + 97);
		}
		
		String Cipher = String.valueOf(CipherText);
		
		return Cipher;
	}
	
	public String Decrypt(String str) { 
			
		char[] DText = new char[str.length()];
		
		for (int i = 0; i < str.length(); i++) { 
			int temp_s = (int) str.charAt(i);
			temp_s = temp_s - 97;
			int y  = mod26(temp_s - Shift);
			//System.out.println(y); 
			DText[i] = (char)(y + 97);
		}
		
		String Plain = String.valueOf(DText);
		
		return Plain;
	}
	
	public int mod26(int x) {
	
		if (x < 0)
			return ( (x + 26) % 26);
		else	
			return ( x % 26);
	}
	
public static void main(String[] args) { 
	
		Scanner in = new Scanner(System.in);
		
		System.out.println("\n\nEnter any text:");

		String str1 = in.nextLine();		
		
		//Converts the text to lower case
		String str2 = str1.toLowerCase();
		
		System.out.println("\n\nEnter the value of shift:");
		int N = in.nextInt();
		ShiftCipher S1 = new ShiftCipher(N);

/*TO ENCRYPT FIRST AND THEN DECRYPT, UNCOMMENT THE NEXT FOUR LINES. TO DECRYPT THE GIVEN
CIPHERTEXT FOR PROBLEM 2, LEAVE THE NEXT FOUR LINES COMMENTED.*/
 		
		//Encrypting the text
		//String Cipher = Encrypt(str2);
		
		//System.out.println("\nThe encrypted text is: " + Cipher);	
		//System.out.print("\n");
		
		//Decrypting the text
		//String Plain = S1.Decrypt(Cipher);
		String Plain = S1.Decrypt(str2);
		
		System.out.println("\nThe Decrypted text is: " + Plain);		
	}
}
