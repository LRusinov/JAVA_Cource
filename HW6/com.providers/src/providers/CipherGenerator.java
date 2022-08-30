package providers;

import services.Cipherable;

public class CipherGenerator {
    public static Result countDistinct(Cipherable cipher, int seed) {

        char[] randomLetters = cipher.getSecretChars(seed);
        boolean unique;// flag which checks if the symbol is unique
        int uniqueCounter = 0;

        for(int i = 0; i < randomLetters.length; i++) {
            unique = true;
            for(int j = 0; j < randomLetters.length; j++){ //checking if the symbol is unique
                if(randomLetters[i] == randomLetters[j] && i != j){
                    unique = false;
                    break;
                }
            }
            if(unique){
                uniqueCounter++;
            }
        }
        return new Result(randomLetters, uniqueCounter);
    }
}
