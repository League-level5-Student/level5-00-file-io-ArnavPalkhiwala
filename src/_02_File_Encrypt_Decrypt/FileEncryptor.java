package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */

	public static void main(String[] args) {

		String message = JOptionPane.showInputDialog("Enter your message...");

		String key = JOptionPane.showInputDialog("Enter your key...(A whole number between 1 and 26");

		int keyNumber = Integer.parseInt(key);

		String newMessage = "";

		for (int i = 0; i < message.length(); i++) {

			if (message.charAt(i) + keyNumber > 'z' && message.charAt(i) > 96) {

				int distance = 'z' - message.charAt(i);
				int additional = keyNumber - distance;

				newMessage += (char) (97 + additional - 1);

			}

			else if (message.charAt(i) + keyNumber > 'Z' && message.charAt(i) < 91) {

				int distance = 'Z' - message.charAt(i);
				int additional = keyNumber - distance;

				newMessage += (char) (65 + additional-1);

			}

			else if (message.charAt(i) == ' ') {

				newMessage += " ";
			}

			else {

				newMessage += (char) (message.charAt(i) + keyNumber);

			}
		}

		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			fw.write(newMessage);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean isUppercase(char charAt) {
		// TODO Auto-generated method stub
		return false;
	}
}