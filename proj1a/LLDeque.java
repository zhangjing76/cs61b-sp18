import java.util.LinkedList;

public class LLDeque<LochNess> {
    /** An SLList is a list, */
    private class StuffNode { //can be made private if we wanted
        public LochNess item;
        public StuffNode next; //pointer to next element in list
        public StuffNode prev;
        public StuffNode(LochNess i, StuffNode n, StuffNode p) { //constructor = how you start the ojbect
            item = i;
            next = n;
            prev = p;
        }
    }


    // The first item (if it exists) is  at sentinel.next
    private StuffNode sentinel;
    private int size;

    /**Constructor*/
    public LLDeque(LochNess x) {
        sentinel = new StuffNode(null, null, null); //sentinel is a pointer to the sentinel
        sentinel.next = new StuffNode(x, sentinel, sentinel); //first point to instance of StuffNode
        sentinel.prev = sentinel.next;
        size = 1;
    }
    //L only has first as its data. it is not an StuffNode is it a SLList

    /**New empty LLDeque (constructor) */
    public LLDeque() {
        sentinel = new StuffNode(null, sentinel, sentinel);
        size = 0;
    }

    /** Adds x to the front of the list.  */
    public void addFirst(LochNess x) { //what if there is no items in list
        StuffNode newFirst = new StuffNode(x, sentinel.next, sentinel);
        sentinel.next = newFirst;
        if (size == 0) {
            sentinel.prev = newFirst;
        }
        else {
            newFirst.next.prev = newFirst;
        }
        size += 1;
    }

    /** Adds x to the end of the list.  */
    public void addLast(LochNess x) {
        StuffNode newLast = new StuffNode(x, sentinel, sentinel.prev);
        newLast.prev.next = newLast;
        sentinel.prev = newLast;

        size+=1;
    }

    /**Checks is list is empty*/
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**Prints size*/
    public int size() {
        return size;
    }

    /**Prints entire Deque from front to back*/
    public void printDeque() {
        StuffNode p = sentinel.next;
        for (int i = 1; i <= size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /**Removes the first value of the list*/
    public LochNess removeFirst() {
        if (sentinel.next == null) {
            return null;
        } else if (sentinel.next.next == null){ //only 1 item in list
            LochNess prevFirst = sentinel.next.item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size -= 1;
            return prevFirst;
        } else {
            LochNess prevFirst = sentinel.next.item;
            StuffNode newFirst = sentinel.next.next;
            newFirst.prev = sentinel;
            sentinel.next = newFirst;
            size = size-1;
            return prevFirst;

        }
    }

    /** removes last value of list*/
    public LochNess removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1){
            LochNess prevLast = sentinel.prev.item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size = 0;
            return prevLast;
        } else {
            LochNess prevLast = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return prevLast;
        }
    }

    /**Gets item at index using recursion*/
    public LochNess get(int index) {
        StuffNode p = sentinel.next; //p is the first value
        if (index > size-1 || index < 0) { //0 is first, 1 is next...
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /**Gets item at index using recursion*/
    public LochNess getRecursive(int index) {
        return getRecursiveImpl(sentinel.next, index);
    }
    /**Gets item at index */
    private LochNess getRecursiveImpl(StuffNode p, int index) {
        if (index == 0) //base case - at desired index
            return p.item;

        return getRecursiveImpl(p.next, index - 1);
    }

    /**Creates empty LLDeque*/
    public void LinkedListDeque(){
        sentinel = new StuffNode(null, sentinel, sentinel);
        size = 0;
    }
}
