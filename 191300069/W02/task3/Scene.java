package W02.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Scene{

    public static void main(String[] args) throws IOException {

        int num = 256;
        int[] a = new int[num];
        boolean[] b = new boolean[num];
        Random rand = new Random(47);
        for(int i = 0; i < num; i++){
            while(true){
                int r = rand.nextInt(num);
                if(!b[r]){
                    a[i] = r;
                    b[r] = true;
                    break;
                }
            }
        }
        SnakeSpirit theSnakeSpirit = SnakeSpirit.getTheSnakeSpirit();

        Sorter sorter;
        sorter = new QSorter();
        //sorter = new BSorter();
        //sorter = new SSorter();
        theSnakeSpirit.setSorter(sorter);

        String log;

        int column = 16;
        Matrix matrix = new Matrix(num/column, column);

        for (int i = 0; i < num; i++) {
            rand = new Random(i*i+2*i+3506);
            Goblin goblin;
            if(i < 36){//red
                goblin = new Goblin(i,4*i+115, 0, 0);
            }
            else if(i < 72){//orange
                goblin = new Goblin(i,255, 97+2*(i-36), 0);
            }
            else if(i < 108){//yellow
                goblin = new Goblin(i,200, 100+2*(i-72), 0);
            }
            else if(i < 144){//green
                goblin = new Goblin(i,48, 128+2*(i-108), 20+(i-108));
            }
            else if(i < 180){//cyan
                goblin = new Goblin(i,0, 255-2*(i-144), 255-(i-144));
            }
            else if(i < 216){//blue
                goblin = new Goblin(i,30+(i-180)/2, 100+2*(i-180), 255-(i-180));
            }
            else{//purple
                    goblin = new Goblin(i,138+(i-216), 43+2*(i-216), 200+(i-216));
            }
            matrix.put(goblin,a[i]/column, a[i]%column);
        }

        log = theSnakeSpirit.matrixUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}
