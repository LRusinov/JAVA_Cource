package problem1;

import java.util.Scanner;

public class Hamming {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the first 8-bit num: ");
        byte firstNum = inputScanner.nextByte();//the first 8-bit digit

        System.out.print("Enter the second 8-bit num:");
        byte secondNum = inputScanner.nextByte();//the second 8-bit digit

        //printing 8-digit bytes with zeros at the beginning and no white spaces
        System.out.print("First 8-byte num is: ");
        System.out.println(String.format("%8s", Integer.toBinaryString(firstNum)).replace(' ', '0'));

        System.out.print("Second 8-byte num is: ");
        System.out.println(String.format("%8s", Integer.toBinaryString(secondNum)).replace(' ', '0'));

        int differences = firstNum ^ secondNum;//8-digit byte with '1' on the positions with differences
        int counter = 0;

        //algorithm which find the num of the ones of "differences"
        while (differences != 0) {
            counter++;
            differences = differences & (differences - 1);
        }
        System.out.println(counter);
    }
}
