package providers;

import services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper(int size) {
        setSize(size);
    }


    public void setSize(int size) {
        if (size < 0) {   //size validation
            System.out.println("Invalid size!");
            this.size = 0;
        } else {
            this.size = size;
        }
    }

    public int getSize() {
        return size;
    }

    class FixedRandom implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            char[] randomLetters = new char[size];
            Random random = new Random(seed);//random generator with Random c-tor with parameters
            for (int i = 0; i < randomLetters.length; i++) {
                //generating random symbols (65-90 letters in ASCII tables)
                randomLetters[i] = (char) (random.nextInt(65, 91));
            }

            return randomLetters;
        }
    }

    public Cipherable makeFixedSelection() {
        return new FixedRandom();
    }

    class FixesSelection implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random();//random generator
            char[] randomLetters = new char[size];
            char[] randomList = new char[seed];

            for (int i = 0; i < randomList.length; i++) {
                //generating random symbols (65-90 letters in ASCII tables)
                randomList[i] = (char) (random.nextInt(65, 91));
            }

            for (int i = 0; i < randomLetters.length; i++) {
                //generating random indexes
                randomLetters[i] = randomList[random.nextInt(seed)];
            }

            return randomLetters;
        }
    }

    public Cipherable makeFixedRandom() {
        return new FixesSelection();
    }


}
