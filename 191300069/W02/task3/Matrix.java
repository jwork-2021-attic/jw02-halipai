package W02.task3;

public class Matrix{

    public Matrix(int row, int column) {
        this.pos= new Pos[row][column];
        this.row = row;
        this.column = column;
    }

    private Pos[][] pos;
    public int row, column;

    public void put(Goblin goblin, int i, int j) {
        if (this.pos[i][j] == null) {
            this.pos[i][j] = new Pos(null);
        }
        this.pos[i][j].setLinable(goblin);
    }

    public Linable get(int i, int j) {
        if ((i < 0) || (i > pos.length) || (j < 0) || (j > pos[0].length)) {
            return null;
        } else {
            return pos[i][j].goblin;
        }
    }
    class Pos {
        private Goblin goblin;

        Pos(Goblin goblin) {
            this.goblin = goblin;
        }

        public void setLinable(Goblin goblin) {
            this.goblin = goblin;
            goblin.setPos(this);
        }
    }

    public Goblin selectElement(int i, int j){
        return this.pos[i][j].goblin;
    }

    @Override
    public String toString() {
        String lineString = "\t";
        for (int i = 0; i < row*column; i++) {
            lineString += pos[i/column][i%column].goblin.toString();
            if(i%column == column-1){
                lineString +="\n\t";
            }
        }
        lineString +="\n";
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.pos.length*this.pos[0].length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = pos[i/column][i%column].goblin;
        }

        return linables;

    }
}