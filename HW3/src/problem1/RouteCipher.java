package problem1;

public class RouteCipher {
    private int key;


    public RouteCipher(int key) {
        setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if (key == 0) {
            System.out.println("Invalid key");
        }
        this.key = key;
    }

    private int lengthWithoutOtherChars(char[] plainText, int columnNum) { //returning the length of the arr without
        int indexCounter = 0;                                   //symbols different from letters
        int length = plainText.length;
        for (int i = 0; i < (int) Math.ceil((double) length / columnNum); i++) {
            for (int j = 0; j < columnNum; j++) {
                while (indexCounter < plainText.length &&
                        (plainText[indexCounter] < 'A' ||
                                plainText[indexCounter] > 'Z' && plainText[indexCounter] < 'a' ||
                                plainText[indexCounter] > 'z')
                ) {
                    indexCounter++;
                    length--;
                }
                if (indexCounter < plainText.length) {
                    indexCounter++;
                } else {
                    length++;
                }
            }
        }
        return length;
    }

    private char[][] removingOtherChars(char[] plainText, int rowNum, int columnNum, int length) {
        //removing all symbols different from letters
        //and writing it in grid
        int indexCounter = 0;//index of plaintText
        char[][] grid = new char[rowNum][columnNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                while (indexCounter < plainText.length && //checking if the symbol is letter
                        (plainText[indexCounter] < 'A' ||
                                plainText[indexCounter] > 'Z' && plainText[indexCounter] < 'a' ||
                                plainText[indexCounter] > 'z')
                ) {
                    indexCounter++;
                    length--;
                }
                if (indexCounter < plainText.length) {
                    grid[i][j] = plainText[indexCounter];
                    indexCounter++;
                } else { //when we reach the end of the cipherText filling the rest of the grid with X
                    grid[i][j] = 'X';
                    length++;
                }
            }
        }
        return grid;
    }

    private char[] negativeKeyEncrypt(char[][] grid, int length, int rowsNum, int columnNum) {
        //if the key is negative we encrypt starting from bottom right
        char[] encryptedCharArr = new char[length];
        int x;               //used for as first coordinate of the grid
        int y = columnNum - 1;//used as second coordinate of the grid
        int indexCounter = 0;//index of the encryptedChar
        int whileCounter = 0;//counting how many times the while was turned
        while (indexCounter < length) { //with this while we are walking through the cipher path
            //and putting the result in char array

            for (int i = rowsNum - whileCounter - 1; i >= whileCounter; i--) {
                //walking from bottom right to top right
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[i][y];
                indexCounter++;
            }
            x = whileCounter;

            for (int i = columnNum - whileCounter - 2; i >= whileCounter; i--) {
                //walking from top right to top left
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[x][i];
                indexCounter++;
            }
            y = whileCounter;

            for (int i = x + 1; i < rowsNum - whileCounter - 1; i++) {
                //walking from top left to bottom left
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[i][y];
                indexCounter++;

            }

            x = rowsNum - whileCounter - 1;
            whileCounter++;
            for (int i = y; i <= columnNum - whileCounter - 1; i++) {
                //walking from bottom left to bottom right
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[x][i];
                indexCounter++;
            }
            y = columnNum - whileCounter - 1;
        }

        return encryptedCharArr;//returning the encrypted char array
    }

    private char[] positiveKeyEncrypt(char[][] grid, int length, int rowsNum, int columnNum) {
        //if the key is positive we encrypt starting from bottom right

        int x = 0;           //used for as first coordinate of the grid
        int y = 0;           //used for as second coordinate of the grid
        int whileCounter = 0;//counting how many times the while was turned
        int indexCounter = 0;//index of the encryptedChar
        char[] encryptedCharArr = new char[length];

        while (indexCounter < length) { //with this while we are walking through the cipher path
            //and putting the result in char array

            for (int i = x; i < rowsNum - whileCounter - 1; i++) {
                //walking from top left to bottom left
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[i][y];
                indexCounter++;

            }

            x = rowsNum - whileCounter - 1;
            for (int i = y; i < columnNum - whileCounter; i++) {
                //walking from bottom left top bottom right
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[x][i];
                indexCounter++;
            }

            whileCounter++;
            y = columnNum - whileCounter;
            for (int i = rowsNum - whileCounter - 1; i >= whileCounter; i--) {
                //walking from bottom right to top right
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[i][y];
                indexCounter++;
            }

            x = whileCounter - 1;
            for (int i = columnNum - whileCounter; i > whileCounter; i--) {
                //walking from top right to top left
                if (indexCounter == length) {
                    break;
                }
                encryptedCharArr[indexCounter] = grid[x][i];
                indexCounter++;
            }
            y = whileCounter;
        }

        return encryptedCharArr; //returning the encrypted char array
    }

    public String encrypt(String plainText) {

        char[] plainTextChars = plainText.toCharArray();
        int columnNum = Math.abs(key); //taking the abs value of the key for num of the columns in the grid
        char[][] grid;
        int length = lengthWithoutOtherChars(plainTextChars, columnNum);
        int rowsNum = (int) Math.ceil((double) length / columnNum);// calculating the num of the rows in the grid
        grid = removingOtherChars(plainTextChars, rowsNum, columnNum, length);//setting the grid for encryption

        char[] encryptedArray = new char[length];
        if (key > 0) {
            encryptedArray = positiveKeyEncrypt(grid, length, rowsNum, columnNum);
        } else if (key < 0) {
            encryptedArray = negativeKeyEncrypt(grid, length, rowsNum, columnNum);
        } else {
            System.out.println("Invalid key!");
        }

        return new String(encryptedArray);
    }

    private char[][] negativeKeyDecrypt(char[] cipherTextChars, int rowsNum, int columnNum, int length) {
        //decrypting cipher with negative key and returning its grid

        char[][] grid = new char[rowsNum][columnNum];
        int indexCounter = 0;
        int x;
        int y = columnNum - 1;
        int whileCounter = 0;
        while (indexCounter < length) {//with this while we are walking through the decrypt path
            //and putting the result in char array

            for (int i = rowsNum - whileCounter - 1; i > whileCounter; i--) {
                if (indexCounter == length) {
                    break;
                }
                grid[i][y] = cipherTextChars[indexCounter];
                indexCounter++;
            }

            x = whileCounter;
            for (int i = columnNum - whileCounter - 1; i > whileCounter; i--) {
                if (indexCounter == length) {
                    break;
                }
                grid[x][i] = cipherTextChars[indexCounter];
                indexCounter++;
            }

            y = whileCounter;
            for (int i = x; i < rowsNum - whileCounter - 1; i++) {
                if (indexCounter == length) {
                    break;
                }
                grid[i][y] = cipherTextChars[indexCounter];
                indexCounter++;

            }

            x = rowsNum - whileCounter - 1;
            whileCounter++;
            for (int i = y; i <= columnNum - whileCounter - 1; i++) {
                if (indexCounter == length) {
                    break;
                }
                grid[x][i] = cipherTextChars[indexCounter];
                indexCounter++;
            }
            y = columnNum - whileCounter - 1;
        }

        return grid;
    }

    private char[][] positiveKeyDecrypt(char[] cipherTextChars, int rowsNum, int columnNum, int length) {
        //decrypting cipher with positive key and returning its grid

        char[][] grid = new char[rowsNum][columnNum];
        int indexCounter = 0;
        int x = 0;
        int y = 0;
        int whileCounter = 0;

        while (indexCounter < length) { //with this while we are walking through the decrypt path
            //and putting the result in char array

            for (int i = x; i < rowsNum - whileCounter - 1; i++) {
                if (indexCounter == length) {
                    break;
                }
                grid[i][y] = cipherTextChars[indexCounter];
                indexCounter++;
            }

            x = rowsNum - whileCounter - 1;
            for (int i = y; i < columnNum - whileCounter; i++) {
                if (indexCounter == length) {
                    break;
                }
                grid[x][i] = cipherTextChars[indexCounter];
                indexCounter++;
            }

            whileCounter++;
            y = columnNum - whileCounter;
            for (int i = rowsNum - whileCounter - 1; i >= whileCounter; i--) {
                if (indexCounter == length) {
                    break;
                }
                grid[i][y] = cipherTextChars[indexCounter];
                indexCounter++;
            }

            x = whileCounter - 1;
            for (int i = columnNum - whileCounter; i > whileCounter; i--) {
                if (indexCounter == length) {
                    break;
                }
                grid[x][i] = cipherTextChars[indexCounter];
                indexCounter++;
            }
            y = whileCounter;
        }
        return grid;
    }

    public String decrypt(String cipherText) {

        char[] cipherTextChars = cipherText.toCharArray();
        int columnNum = Math.abs(key);
        int rowsNum = cipherTextChars.length / columnNum;
        int length = cipherTextChars.length;
        char[][] grid = new char[rowsNum][columnNum];

        if (key > 0) {
            grid = positiveKeyDecrypt(cipherTextChars, rowsNum, columnNum, length);
        } else if (key < 0) {
            grid = negativeKeyDecrypt(cipherTextChars, rowsNum, columnNum, length);
        } else {
            System.out.println("Invalid key!");
        }

        int indexCounter = 0;
        char[] decryptedArray = new char[length + 1];
        for (int i = 0; i < rowsNum; i++) {  //writing the grid text into char array
            for (int j = 0; j < columnNum; j++) {
                decryptedArray[indexCounter] = grid[i][j];
                indexCounter++;
            }
        }
        for (int i = 0; i < length; i++) { //checking if there are X-es at the end of the array and removing them
            if (decryptedArray[i] == 'X' && decryptedArray[i + 1] == 'X') {
                length = i;
                break;
            } else if (decryptedArray[i] == 'X' && length == i + 1) {
                length = i;
                break;
            }
        }

        char[] decryptedCharArr = new char[length];
        System.arraycopy(decryptedArray, 0, decryptedCharArr, 0, length);
        //copying the array to new without X-es at the end

        return new String(decryptedCharArr);
    }

    @Override
    public String toString() {
        return "RouteCipher{" +
                " key= " + key +
                " }";
    }
}
