package problem2;

public class SquareMatrix {
    private int[][] dataArray;
    private final int SIZE;//const size of the square matrix

    public SquareMatrix() {
        SIZE = 0;
    }

    public SquareMatrix(int[][] dataArray, int nSize) {
        this.dataArray = dataArray;
        this.SIZE = nSize;
    }

    public SquareMatrix(SquareMatrix other) {
        SIZE = other.SIZE;
        dataArray = other.dataArray;
    }

    public void setDataArray(int[][] dataArray) {
        this.dataArray = dataArray;
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixString.append(dataArray[i][j]).append(" ");
            }
            matrixString.append('\n');
        }

        return matrixString.toString();
    }

    private int sumOfSubMatrix(int x, int y) {//finding the sum of 2x2 sub matrix

        return dataArray[x][y] + dataArray[x][y + 1] +
                dataArray[x + 1][y + 1] + dataArray[x + 1][y];
    }

    public int findMaxSum() {
        int maxSum = sumOfSubMatrix(0, 0);

        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (maxSum < sumOfSubMatrix(i, j)) {
                    maxSum = sumOfSubMatrix(i, j);
                }
            }
        }

        return maxSum;
    }

    public void printAll() {
        int maxSum = findMaxSum();
        System.out.printf("Max sum is: %d%n", maxSum);
        System.out.println("Sub matrices with Maximum sum: ");
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (sumOfSubMatrix(i, j) == maxSum) {
                    System.out.printf("[%d,%d]%n", i, j);
                }
            }
        }
    }
}
