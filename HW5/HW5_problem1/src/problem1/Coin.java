package problem1;

import java.util.Random;

public class Coin {
    public Face getFace() {
        return face;
    }

    private final Random random;
    private Face face;

    public void setFace(Face face) {
        if (face != null) {
            this.face = face;
        } else {
            System.out.println("Invalid Face! It is set to HEAD");
            this.face = Face.HEAD;
        }
    }

    public Coin(Face face) {
        this.random = new Random();
        setFace(face);
    }

    public void flip() {
        if (random.nextInt(2) == 1) {
            this.face = Face.HEAD;
        } else {
            this.face = Face.TAIL;
        }
    }

    public boolean isHeads() {
        return face == Face.HEAD;
    }

    @Override
    public String toString() {
        return "The face of Coin is: " + face;
    }
}
