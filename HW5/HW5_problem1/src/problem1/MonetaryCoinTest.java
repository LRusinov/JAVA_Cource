package problem1;

public class MonetaryCoinTest {
    public static void main(String[] args) {
        MonetaryCoin mCoin1 = new MonetaryCoin(Face.TAIL, 20);
        MonetaryCoin mCoin2 = new MonetaryCoin(Face.HEAD, 50);
        System.out.println("Coin 1:" + mCoin1);
        System.out.println("Coin 2:" + mCoin2);
        System.out.printf("The sum of the coins is: %d%n", mCoin1.getValue() + mCoin2.getValue());

        System.out.println("Flipping coin 1: ");
        for (int i = 0; i < 10; i++) {
            mCoin1.flip();
            System.out.printf("Flip %d : %s%n", i + 1, mCoin1.getFace());
        }
    }
}
