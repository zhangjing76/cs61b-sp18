public class ArrayDeque<LochNess> {
    /** An ArrayDeque is a list */
    private int size;
    private LochNess[] items;
    private int RFACTOR = 2;

    /**Constructor*/
    public ArrayDeque(LochNess x) {
        items = (LochNess[]) new Object[8];
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
        size += 1;
    }

    public resize(int size)

    /** Adds x to the end of the list.  */
    public void addLast(LochNess x) {

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

    }

    /**Removes the first value of the list*/
    public LochNess removeFirst() {

    }

    /** removes last value of list*/
    public LochNess removeLast() {

    }

    /**Gets item at index using recursion*/
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
        size = 0;
    }
}
