package problem2;

import java.util.Random;

public class SquareMatrixTest {

    public static void main(String[] args) {

        Random randomGenerator = new Random();

        int size = randomGenerator.nextInt(2, 13);//generating size of matrix

        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = randomGenerator.nextInt(0, 9);
            }
        }

        SquareMatrix s = new SquareMatrix(arr, size);
        System.out.print(s);
        s.printAll();
    }

}
