package utils;

public class Gcd {
    private int greatestCommonDivider;
    private int x;
    private int y;

    public Gcd(int greatestCommonDivider, int x, int y) {
        this.greatestCommonDivider = greatestCommonDivider;
        this.x = x;
        this.y = y;
    }

    public void setGreatestCommonDivider(int greatestCommonDivider) {
        this.greatestCommonDivider = greatestCommonDivider;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getGreatestCommonDivider() {
        return greatestCommonDivider;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
