package test;

import string_Encrypt_Decrypt.ConvertEncryptDecrypt;

public class Test {
	public static void main(String[] args) {

        String plainText = "hello world!";
		String keyText = "6f58a93fe1d207fae4ed2f6d82f5a12f";
		String encryptedMsg = ConvertEncryptDecrypt.EncryptString(ConvertEncryptDecrypt.plainTextToHexString(plainText),
				ConvertEncryptDecrypt.plainTextToHexString(keyText));
		String decryptedMsg = ConvertEncryptDecrypt.DecryptString(encryptedMsg,
				ConvertEncryptDecrypt.plainTextToHexString(keyText));

		System.out.println("Plain text: " + plainText);
		System.out.println("Key text: " + keyText);
		System.out.println("Encrypted message: " + encryptedMsg);
		System.out.println("Decrypted message: " + ConvertEncryptDecrypt.hexToString(decryptedMsg));
	}
}
