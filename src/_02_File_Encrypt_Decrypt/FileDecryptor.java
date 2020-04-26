package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */

	public static void main(String[] args) {

		int key = 4;
		String newMessage = "";

		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/file.txt");
			int c = fr.read();
			String message = "";
			while (c != -1) {
//				System.out.print((char) c);
				char character = (char) c;
				message += character;

				c = fr.read();

			}

			System.out.println(message);

			for (int i = 0; i < message.length(); i++) {

				if (message.charAt(i) == ' ') {

					newMessage += " ";
				}

				else if (message.charAt(i) - key < 'A' && message.charAt(i) < 91) {

					int distance = message.charAt(i) - 'A';
					int additional = key - distance;

					newMessage += (char) ('Z' - additional + 1);

				}

				else if (message.charAt(i) - key < 'a' && message.charAt(i) > 96) {
					int distance = message.charAt(i) - 'a';
					int additional = key - distance;

					newMessage += (char) ('z' - additional + 1);

				}

				else {

					newMessage += (char) (message.charAt(i) - key);

				}

			}

			JOptionPane.showMessageDialog(null, newMessage);

			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
