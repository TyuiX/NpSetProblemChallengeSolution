
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class hw4cse {
    int target, size;
    LinkedHashMap sets;
    Storage[] amount;
    int leastSize = -1;
    LinkedList<Storage> missing;
    long startTime;
    public hw4cse(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        target = Integer.parseInt(scan.nextLine());
        size = Integer.parseInt(scan.nextLine());
        int start = 0;
        amount = new Storage[target];
        sets = new LinkedHashMap();
        missing = new LinkedList<Storage>();
        for (int i = 0; i < size; i ++)
            sets.put(i, new LinkedHashMap());
        for (int i = 0; i < target; i++) {
            amount[i] = new Storage();
        }
        while (scan.hasNextLine()){
            String set = scan.nextLine();
            if (set.equals(""))
                start++;
            else {
                for (String i : set.split(" ")) {
                    int x = Integer.parseInt(i);
                    LinkedHashMap z = (LinkedHashMap) sets.get(start);
                    z.put(x , x);
                    amount[x - 1].addAmount();
                    amount[x - 1].addContainer(start);
                }
                start++;
            }
        }
        for (int i = 0; i < target; i++) {
            amount[i].setIndex(i);
            missing.add(amount[i]);
        }
        Collections.sort(missing);
    }
    public LinkedList <Integer> combinationhelper (LinkedList<Integer> combolist){
        startTime = System.nanoTime();
        LinkedList<Integer> x = null;
        HashMap dontinclude = new HashMap();
        for (int j : missing.get(0).getContainers()){
            HashMap c = (HashMap) dontinclude.clone();
            LinkedList<Integer> y = combination(j, combolist, missing, 1, c);
            combolist.removeLast();
            dontinclude.put(j, j);
            System.out.println(dontinclude);
            if (y == null)
                return x;
            if (y != null) {
                if (y.size() == 1)
                    return y;
                if (x == null || y.size() < x.size())
                    x = y;
            }

        }
        return x;
    }

    public LinkedList<Integer> combination (int choice, LinkedList<Integer> combolist, LinkedList<Storage> U, int k, HashMap list) {
        LinkedList<Integer> x = null;
        combolist.add(choice);
        if (combolist.size() >= leastSize && leastSize > 0)
            return (LinkedList<Integer>) combolist.clone();
        LinkedList<Storage> newU = new LinkedList<>();
        for (Storage i: U){
            LinkedHashMap c = (LinkedHashMap) sets.get(choice);
            if (!(c.containsKey(i.getIndex() + 1)))
                newU.add(i);
        }
        if (newU.size() == 0) {
            leastSize = combolist.size();
            return (LinkedList<Integer>) combolist.clone();
        }
        for (int i : newU.get(0).getContainers()){
            if (!(list.containsKey(i))) {
                int count = k + 1;
                HashMap c = (HashMap) list.clone();
                LinkedList<Integer> y = combination(i, combolist, newU, count, c);
                combolist.removeLast();
                list.put(i, i);
                if (y == null)
                    return x;
                else {
                    if (y.size() == k)
                        return y;
                    if (x == null || (y.size() < x.size() && y.size() != 0))
                        x = y;
                }
            }
        }
        return x;

    }
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        //change file path here to the file you want to test
        File file = new File("C:\\Users\\jason\\OneDrive\\Documents\\test.txt");
        hw4cse solution = new hw4cse(file);
        LinkedList<Integer> x = solution.combinationhelper(new LinkedList<Integer>());
        System.out.println(x.size());
        System.out.println((System.nanoTime() - startTime)/1000000 + " ms");
        for (int i: x){
            System.out.println("set " +(i + 1));
            LinkedHashMap c = (LinkedHashMap) solution.sets.get(i);
            System.out.println(c.keySet());
        }
    }
}

