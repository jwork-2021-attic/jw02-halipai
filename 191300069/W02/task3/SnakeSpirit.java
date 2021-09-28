package W02.task3;

public class SnakeSpirit{

    private static SnakeSpirit theSnakeSpirit;

    public static SnakeSpirit getTheSnakeSpirit() {
        if (theSnakeSpirit == null) {
            theSnakeSpirit = new SnakeSpirit();
        }
        return theSnakeSpirit;
    }

    private SnakeSpirit() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String matrixUp(Matrix matrix) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = matrix.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());
        System.out.println(matrix.toString());

        if(!sortSteps[0].isEmpty()){
            for (String step : sortSteps) {
                this.execute(step, matrix);
                System.out.println(matrix.toString());
                log += matrix.toString();
                log += "\n[frame]\n";
            }
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step, Matrix matrix) {
        String[] couple = step.split("<->");
        matrix.selectElement(Integer.parseInt(couple[0])/matrix.column, Integer.parseInt(couple[0])%matrix.column)
        .swapPos(matrix.selectElement(Integer.parseInt(couple[1])/matrix.column, Integer.parseInt(couple[1])%matrix.column));
    }
}