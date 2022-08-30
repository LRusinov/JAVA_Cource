package providers;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        setChars(chars);
        setData(data);
    }

    public void setChars(char[] chars) {
        this.chars = new char[chars.length];
        System.arraycopy(chars, 0, this.chars, 0, chars.length);
    }

    public void setData(int data) {
        if (data < 0) { //validating data
            System.out.println("Invalid data value!");
            this.data = 0;
        } else {
            this.data = data;
        }
    }

    public char[] getChars() {
        char[] newChars = new char[chars.length];
        System.arraycopy(chars, 0, newChars, 0, chars.length);
        return newChars;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Data: " + data + "\nChars: ");
        for (char ch : chars) {
            result.append(ch);
            result.append(" ");
        }
        return result.toString();
    }
}
