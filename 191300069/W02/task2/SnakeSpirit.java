package W02.task2;

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

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());
        System.out.println(line.toString());

        if(!sortSteps[0].isEmpty()){
            for (String step : sortSteps) {
                this.execute(step, line);
                System.out.println(line.toString());
                log += line.toString();
                log += "\n[frame]\n";
            }
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step, Line line) {
        String[] couple = step.split("<->");
        line.selectElement(Integer.parseInt(couple[0]))
        .swapPosition(line.selectElement(Integer.parseInt(couple[1])));
    }
}