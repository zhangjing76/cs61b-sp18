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

    /**New empty SLList */
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

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode p = sentinel.next;
        for (int i = 1; i <= size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public LochNess removeFirst() {
        if (sentinel.next == null) {
            return null;
        } else if (sentinel.next.next == null){ //only 1 item in list
            size -= 1;
            LochNess prevFirst = sentinel.next.item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
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

    public LochNess removeLast() {
        if (sentinel.prev == null) {
            return null;
        } else {
            LochNess prevLast = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel; //new last points to sentinel as next
            sentinel.prev = sentinel.prev.prev; //sentinel's previous now points to the new last
            size = size-1;
            return prevLast;
        }
    }

    public LochNess get(int index) {
        StuffNode p = sentinel.next;
        if (index > size-1) {
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

    /*
    public LochNess getRecursive(int index) {
        return getRecursiveImpl(sentinel.next, index);
    }
    private LochNess getRecursiveImpl(StuffNode p, int index) {
        if (index == 0)
            return p.item;

        return gtRecursiveImpl(p.next, index - 1);
    }
     */

    /*
    * public LinkedListDeque() [create empty linked list]*/

    public static void main(String[] args) {
        LLDeque<Integer> LinkedListDeque = new LLDeque<Integer>(5);
        LinkedListDeque.addFirst(1);
        LinkedListDeque.addFirst(2);
        LinkedListDeque.addFirst(3);
        LinkedListDeque.removeFirst();
        LinkedListDeque.printDeque();

    }
}
