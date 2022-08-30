package problem1;

public class MonetaryCoin extends Coin {
    private int value;

    public MonetaryCoin(Face face, int value) {
        super(face);
        setValue(value);
    }


    public void setValue(int value) {
        if (value > 0) {
            this.value = value;
        } else {
            System.out.println("Invalid value!");
            this.value = 1;
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString() + " Value:" + value;
    }
}

