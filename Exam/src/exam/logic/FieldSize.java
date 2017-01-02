package exam.logic;

public enum FieldSize {

    EIGHT(8, 8),
    TEN(10, 10),
    TWELVE(12, 12);

    private int n;
    private int m;

    FieldSize(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    @Override
    public String toString() {
        return n + " by " + m;
    }
}
