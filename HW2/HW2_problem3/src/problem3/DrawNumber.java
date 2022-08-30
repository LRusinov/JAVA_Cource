package problem3;

import java.text.NumberFormat;
import java.util.Random;

public class DrawNumber {
    public static int drawRandomNumber() {
        int[] arrayToDraw = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 3};
        Random random = new Random();
        return arrayToDraw[random.nextInt(10)];
    }

    public static void main(String[] args) {

        int counterOf1 = 0;
        int counterOf2 = 0;
        int counterOf3 = 0;
        int drewNumber;

        for (int i = 0; i < 10000; i++) {
            drewNumber = drawRandomNumber();
            if (drewNumber == 1) {
                counterOf1++;
            }
            if (drewNumber == 2) {
                counterOf2++;
            }
            if (drewNumber == 3) {
                counterOf3++;
            }

        }
        System.out.println("In the loop of 10 000");
        System.out.println("1 was drawn: " + counterOf1 / 10000.0 + " In percents:"
                + NumberFormat.getPercentInstance().format(counterOf1 / 10000.0));
        System.out.println("2 was drawn: " + counterOf2 / 10000.0 + " In percents:"
                + NumberFormat.getPercentInstance().format(counterOf2 / 10000.0));
        System.out.println("3 was drawn: " + counterOf3 / 10000.0 + " In percents:"
                + NumberFormat.getPercentInstance().format(counterOf3 / 10000.0));


        counterOf1 = 0;
        counterOf2 = 0;
        counterOf3 = 0;

        for (int i = 0; i < 60000; i++) {
            drewNumber = drawRandomNumber();
            if (drewNumber == 1) {
                counterOf1++;
            }
            if (drewNumber == 2) {
                counterOf2++;
            }
            if (drewNumber == 3) {
                counterOf3++;
            }
        }

        System.out.println("\nIn the loop of 60 000");
        System.out.println("1 was drawn: " + counterOf1 / 60000.0 + " In percents:"
                + NumberFormat.getPercentInstance().format(counterOf1 / 60000.0));
        System.out.println("2 was drawn: " + counterOf2 / 60000.0 + " In percents:"
                + NumberFormat.getPercentInstance().format(counterOf2 / 60000.0));
        System.out.println("3 was drawn: " + counterOf3 / 60000.0 + " In percents:"
                + NumberFormat.getPercentInstance().format(counterOf3 / 60000.0));
    }
}
