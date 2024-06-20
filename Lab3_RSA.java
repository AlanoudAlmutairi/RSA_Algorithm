package org.example;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class Lab3_2105088_Alanoud {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter the message : ");
        Scanner input = new Scanner(System.in);

        //String we want to encrypt
        String  message= input.nextLine();

        //convert string to byte array using getBytes() method
        byte[] myBytes  =message.getBytes();

        KeyPairGenerator generator =KeyPairGenerator.getInstance("RSA");

        //pair of Keys :
        KeyPair myPair= generator.generateKeyPair();
        PublicKey pk = myPair.getPublic();
        PrivateKey pv = myPair.getPrivate();

        //create Cipher:
        Cipher cipher1 = Cipher.getInstance("RSA");
        cipher1.init(Cipher.ENCRYPT_MODE,pk);

        //Encryption :
        byte[] EncryptedBytes = cipher1.doFinal(myBytes);
        String encryptedTEXT =  Base64.getEncoder().encodeToString(EncryptedBytes);

        //Decryption :
        cipher1.init(Cipher.DECRYPT_MODE,pv);
        byte[] DecryptBytes = cipher1.doFinal(EncryptedBytes);
        String decryptedData = new String(DecryptBytes);

        System.out.println("Message : "+ message);
        System.out.println("Encrypted - "+ encryptedTEXT);
        System.out.println("Decrypted Message - "+ decryptedData);




    }
}
