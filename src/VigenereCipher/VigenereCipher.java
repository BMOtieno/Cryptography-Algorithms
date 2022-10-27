package VigenereCipher;

import java.util.Scanner;

public class VigenereCipher {
	/**
	 * 
	 * @author Brian Otieno Odhiambo.
	 * 
	 */
	
	/****************************************************************************************/   
	/* The Vigenere class implements the vigenere encryption algorithm. It encrypts a plaintext
	into ciphertext using a key.The key is formed by repeating some word against the plaintext
	message. That word is the base key, which is used to form the actual key.

	Assumptions:

			-	We ignore the spaces and punctuations in the plaintext.
				
			-	We do not differentiate between uppercase and lowercase letters in the
				plaintext.
				
	*/
	/****************************************************************************************/  			
		//Instance variable (the base key)
		private String key;
		
		//Constructor
		public VigenereCipher(String k) { 	
			key = k;
		}
		
		public String vigEncrypt(String str) { 
				
			char[] EncryptKey = new char[str.length()];
			char[] tempKey    = key.toCharArray();
			
			int[] A = new int[str.length()];
			int[] B = new int[str.length()];
			int[] C = new int[str.length()];
			
			str = str.toLowerCase();
			//char[] PlainText  = str.toCharArray();
			char[] CipherText = new char[str.length()];
			
			for (int i = 0; i < str.length(); i++) { 
				EncryptKey[i] = tempKey[(i + key.length()) % (key.length())];
			    //System.out.println(EncryptKey[i]);
			}
			
			for (int i = 0; i < str.length(); i++) { 
				int temp_s = (int) str.charAt(i);
				int temp_k = (int) EncryptKey[i];
				A[i] = temp_s - 97;
				B[i] = temp_k - 97;
				C[i] = (A[i] + B[i]) % 26 + 1;
				CipherText[i] = (char)(C[i] + 96);
			}
			
			String Cipher = String.valueOf(CipherText);
			
			//System.out.println(Cipher);
			
			return Cipher;
		}
		
		public String vigDecrypt(String Cipher) { 
		
			char[] DecryptKey = new char[Cipher.length()];
			char[] tempKey    = key.toCharArray();
			int temp_k = 0;int temp_d = 0;
		
			char[] Decrypt  = new char[Cipher.length()];
			
			for (int i = 0; i < Cipher.length(); i++) { 
				DecryptKey[i] = tempKey[(i + key.length()) % (key.length())];
			}
			
			for (int i = 0; i < Cipher.length(); i++) {
				
				temp_k = (int) DecryptKey[i]    - 97;
				temp_d = (int) Cipher.charAt(i) - 97;
									
				Decrypt[i] = (char)( (temp_d - temp_k + 26) % 26 + 97);
				
			}
			
			String DecryptedText = String.valueOf(Decrypt);
			//System.out.println(DecryptedText);
			return DecryptedText;
		}
		
		public static void main(String[] args) { 
			
			VigenereCipher V1 = new VigenereCipher("thisismykey");
		//Vigenere V2 = new Vigenere("abc");
			VigenereCipher V2 = new VigenereCipher("vector");
			VigenereCipher V3 = new VigenereCipher("andromeda");
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("\nEnter a string to encrypt:\n");
			
			String str = in.nextLine();
			
			String Encrypted_1 = V1.vigEncrypt(str);
			System.out.println("\nEncrypted with V1 --> " + Encrypted_1);
			String Decrypted_1 = V1.vigDecrypt(Encrypted_1);
			System.out.println("\nDecrypted with V1 --> " + Decrypted_1);
			
			String Encrypted_2 = V2.vigEncrypt(str);
			System.out.println("\nEncrypted with V2 --> " + Encrypted_2);
			String Decrypted_2 = V2.vigDecrypt(Encrypted_2);
			System.out.println("\nDecrypted with V2 --> " + Decrypted_2);
			
			String Encrypted_3 = V3.vigEncrypt(str);
			System.out.println("\nEncrypted with V3 --> " + Encrypted_3);
			String Decrypted_3 = V3.vigDecrypt(Encrypted_3);
			System.out.println("\nDecrypted with V3 --> " + Decrypted_3);
			System.out.print("\n");
		}
}
