import java.util.Comparator;
import java.util.LinkedList;

public class Storage implements Comparable<Storage> {
    int amount;
    LinkedList<Integer> containers;
    int index;
    public Storage(){
        amount = 0;
        containers = new LinkedList<Integer>();

    }
    public void add(int x){
        amount ++;
        containers.add(x);
    }
    public int getAmount(){
        return amount;
    }
    public LinkedList<Integer> getContainers(){
        return containers;
    }
    public void addAmount(){
        amount++;
    }
    public void addContainer(int x){
        containers.add(x);
    }

    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public int compareTo(Storage o) {
        if (o.getAmount() < amount)
            return 1;
        else if (o.getAmount() == amount)
            return  0;
        else
            return -1;
    }
    public int getIndex(){
        return index;
    }
}
