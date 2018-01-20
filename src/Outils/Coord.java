package Outils;

public class Coord {
    public int x;
    public int y;

    public Coord(int x, int y){
        this.y = y;
        this.x = x;
    }

    public boolean compareTo(Coord coord){
        if (this.x == coord.x && this.y == coord.y)
            return true;
        return false;
    }
}
