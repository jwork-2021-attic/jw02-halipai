package W02.task3;

public class BSorter implements Sorter {
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + i + "<->" + j + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        int n = a.length, k = 0;
        while(k < n){
            int d = k;
            for(int t = d+1; t < n; t++){
                if(a[t] < a[d]){
                    d = t;
                }
            }
            swap(k, d);
            k++;
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}