public class Position {
    public int x;
    public int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Position p) {
        return x == p.getX() && y == p.getY();
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
