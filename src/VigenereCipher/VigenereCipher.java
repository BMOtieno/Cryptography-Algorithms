package VigenereCipher;

public class VigenereCipher {
	/**
	 * 
	 * A program that implements the Vigenere encryption algorithm
	 * @param String input provided by the user and the key to be used for encryption & decryption
	 * @return the output of the encryption/decryption operation
	 * @author Brian Otieno Odhiambo.
	 * 
	 */
	
	//method for encryption
	public static String encrypt(String text, final String key) {
		String output = "";
		text = text.toUpperCase();
		for(int i= 0, j= 0; i< text.length(); i++) {
			char c = text.charAt(i);
			if(c < 'A'|| c > 'Z') continue;
			output += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}
		return output;
	}
	
	//method for decryption
	public static String decrypt(String text, final String key) {
		String output = "";
		text = text.toUpperCase();
		for(int i= 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if(c < 'A' || c > 'Z') continue;
			output += (char)((c - key.charAt(j) + 26) % 26 + 'A');
			j = ++j % key.length();
		}
		return output;
	}
	
	public static void main(String[] args) {
		String key = "FIRECRACKER";
		String input = "Hellenism was the combination of Greek, Persian, and Egyptian cultures. During this remarkable time period, people were encouraged to pursue a formal education and produce many different kinds of art. New forms of math, science, and design made a great impact on society.";
		String encrypt = encrypt(input, key);
		String decrypt = decrypt(encrypt, key);
		
		System.out.println("Input: " + input);
		System.out.println("Encrypted: " + encrypt);
		System.out.println("Decrypted: " + decrypt);
	}

}
