public class tuple implements Comparable<tuple>{
    int index;
    int size;
    public tuple(int index, int size){
        this.index = index;
        this.size = size;
    }

    public int getIndex() {
        return index;
    }
    public int getSize(){
        return size;
    }


    @Override
    public int compareTo(tuple o) {
        if (o.getSize() < size)
            return 1;
        else if (o.getSize() == size)
            return  0;
        else
            return -1;
    }
}