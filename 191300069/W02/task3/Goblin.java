package W02.task3;

import W02.task3.Matrix.Pos;

public class Goblin implements Linable{

    private final int number;
    private final String n;
    private final int r;
    private final int g;
    private final int b;
    private Pos pos;

    Goblin(int number, int r, int g, int b) {
        this.number = number+1;
        this.r = r;
        this.g = g;
        this.b = b;
        if(this.number >= 100)  n = String.valueOf(this.number);
        else if(this.number >= 10) n = "0"+String.valueOf(this.number);
        else    n = "00"+String.valueOf(this.number);
    }

    public int rank() {
        return number;
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + n + "  \033[0m";
    }

    @Override
    public void setPos(Pos pos) {
        this.pos = pos;
    }

    @Override
    public Pos getPos() {
        return this.pos;
    }

    public void swapPos(Goblin another) {
        Pos p = another.pos;
        this.pos.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }
}