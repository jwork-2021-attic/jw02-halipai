package W02.task2;

public class Line{

    public Line(int length) {
        this.positions = new Position[length];
    }

    private Position[] positions;

    public void put(Goblin goblin, int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(goblin);
    }

    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].goblin;
        }
    }

    class Position {

        private Goblin goblin;

        Position(Goblin goblin) {
            this.goblin = goblin;
        }

        public void setLinable(Goblin goblin) {
            this.goblin = goblin;
            goblin.setPosition(this);
        }
    }

    public Goblin selectElement(int i){
        return this.positions[i].goblin;
    }

    @Override
    public String toString() {
        String lineString = "\t";
        for (Position p : positions) {
            //lineString += p.guardian.toString();
            lineString += p.goblin.toString();
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].goblin;
        }

        return linables;

    }

}