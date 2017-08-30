package Outils;

public class Coord {
    public int x = 0;
    public int y = 0;

    public Coord(){
        x = 0;
        y = 0;
    }

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
