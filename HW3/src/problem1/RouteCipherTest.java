package problem1;

import java.util.Scanner;

public class RouteCipherTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter key(4):");
        int inputKey = scanner.nextInt();//input key = 4
        RouteCipher r = new RouteCipher(inputKey);
        System.out.println(r);
        String encryptedText1 = "TIEIXTXXEAHSIHSPNTLT";
        String cipherText1 = r.decrypt(encryptedText1);
        System.out.println("Text after decryption is: " + cipherText1);
        String encryptedText2 = r.encrypt(cipherText1);
        System.out.println("Text after encryption is: " + encryptedText2);

        System.out.print("Enter key(-5/5):");
        inputKey = scanner.nextInt(); //input key = -5/54
        r.setKey(inputKey);
        System.out.println(r);
        String plainText1 = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";
        String cipherText2 = r.encrypt(plainText1);
        System.out.println("Text after encryption is: " + cipherText2);
        String plainText2 = r.decrypt(cipherText2);
        System.out.println("Text after decryption is: " + plainText2);

        System.out.print("Enter key(-5/5):");
        inputKey = scanner.nextInt();//input key = -5/5
        r.setKey(inputKey);
        System.out.println(r);
        String cipherText3 = r.encrypt(plainText1);
        System.out.println("Text after encryption is: " + cipherText3);
        String plainText3 = r.decrypt(cipherText3);
        System.out.println("Text after decryption is: " + plainText3);

    }
}
