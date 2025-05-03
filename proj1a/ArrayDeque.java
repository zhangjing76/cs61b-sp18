public class ArrayDeque<T> {
    /** An ArrayDeque is a list. Non-circular */
    private int size;
    private T[] items;
    private int RFACTOR = 2;

    /**New empty LinkedListDeque (constructor) */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /** Adds x to the front of the list.  */
    public void addFirst(T x) { //what if there is no items in list
        if (size == items.length){
            resize(items.length * RFACTOR);
        }
        System.arraycopy(items, 0, items, 1, size); //move everything down one to fit new
        items[0] = x;
        size += 1;
    }

    private void resize(int newSize){
        T[] a = (T[]) new Object[newSize]; //generic array
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Adds x to the end of the list.  */
    public void addLast(T x) {
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
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T prevFirst = items[0];
        items[0] = null; //don't loiter
        size -= 1;
        System.arraycopy(items, 1, items, 0, size); //move everything to front again
        items[size] = null; //last one is copied twice accidentally. don't loiter
        return prevFirst;
    }

    /** removes last value of list. Don't loiter!*/
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T prevLast = items[size-1];
        items[size-1] = null; //don't loiter
        size -= 1;
        return prevLast;
    }

    /**Gets item at index using iteration*/
    public T get(int index) {
        if (index >=0 && index <= size-1){
            return items[index];
        }
        else {
            return null;
        }
    }

}
