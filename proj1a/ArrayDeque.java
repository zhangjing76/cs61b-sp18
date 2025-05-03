public class ArrayDeque<LochNess> {
    /** An ArrayDeque is a list. Non-circular */
    private int size;
    private LochNess[] items;
    private int RFACTOR = 2;

    /**Constructor*/
    public ArrayDeque(LochNess x) {
        items = (LochNess[]) new Object[8]; //creating generic arrays
        items[0] = x;
        size = 1;
    }

    /**New empty LLDeque (constructor) */
    public ArrayDeque() {
        items = (LochNess[]) new Object[8];
        size = 0;
    }

    /** Adds x to the front of the list.  */
    public void addFirst(LochNess x) { //what if there is no items in list
        if (size == items.length){
            resize(items.length * RFACTOR);
        }
        System.arraycopy(items, 0, items, 1, size); //move everything down one to fit new
        items[0] = x;
        size += 1;
    }

    private void resize(int newSize){
        LochNess[] a = (LochNess[]) new Object[newSize]; //generic array
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Adds x to the end of the list.  */
    public void addLast(LochNess x) {
        if (size == items.length){
            resize(items.length * RFACTOR);
        }
        items[size] = x;
        size+=1;
    }

    /**Checks is list is empty*/
    public boolean isEmpty() {
        return size == 0;
    }

    /**Prints size*/
    public int size() {
        return size;
    }

    /**Prints entire Deque from front to back*/
    public void printDeque() {
        for (int i = 0; i < size; i++){
            System.out.println(items[i]);
        }
    }

    /**Removes the first value of the list. Null out deleted items!*/
    public LochNess removeFirst() {
        LochNess prevFirst = items[0];
        items[0] = null; //don't loiter
        size -= 1;
        System.arraycopy(items, 1, items, 0, size); //move everything to front again
        items[size] = null; //last one is copied twice accidentally. don't loiter
        return prevFirst;
    }

    /** removes last value of list. Don't loiter!*/
    public LochNess removeLast() {
        LochNess prevLast = items[size-1];
        items[size-1] = null; //don't loiter
        size -= 1;
        return prevLast;
    }

    /**Gets item at index using iteration*/
    public LochNess get(int index) {
        if (index >=0 && index <= size-1){
            return items[index];
        }
        else {
            return null;
        }
    }


    /**Creates empty LLDeque*/
    public void ArrayDeque(){
        items = (LochNess[]) new Object[8];
        size = 0;
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        ArrayDeque<Integer> a = new ArrayDeque<>(5);
        a.addFirst(2);
        a.addFirst(3);
        a.addLast(6);
        a.addLast(7);
        a.addLast(8);
        a.addLast(9);
        a.addLast(10);
        a.addLast(11);
        a.addFirst(1);
        a.removeFirst();
        a.removeLast(); //not printing last. need to null last one bc it moves up
        a.printDeque();
    }
}
