package exam.logic.abstraction;

public class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate stepInDirection(Directions direction) {
        return new Coordinate(x + direction.getX(), y + direction.getY());
    }

    @Override
    public String toString() {
        return "C(" + (x + 1) + ", " + (y + 1) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public int compareTo(Coordinate o) {
        return x - o.x == 0 ? y - o.y : x - o.x;
    }
}