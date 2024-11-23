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
    private StuffNode sentinel; //sentinel is a pointer node;   , points to StuffNode instance
    private int size; //this variable belongs to SLList L.

    public LLDeque(LochNess x) {
        sentinel = new StuffNode(null, null, sentinel.next); //sentinel is a pointer to the sentinel
        sentinel.next = new StuffNode(x, null, sentinel); //first point to instance of StuffNode
        size = 1;
    }
    //L only has first as its data. it is not an StuffNode is it a SLList

    /**New empty SLList */
    public LLDeque() {
        sentinel = new StuffNode(null, null, sentinel);
        size = 0;
    }

    /** Adds x to the front of the list.  */
    public void addFirst(LochNess x) {
        sentinel.next = new StuffNode(x, sentinel.next, sentinel);
        //first = new StuffNode(x, first);
        size += 1;
    }

    /*
    // Returns the first item in the list
    public LochNess getFirst() { //can still use first because it is not a class, it is a method
        return sentinel.next.item;
    }
    */

    /** Adds an item to the end of the list.  */
    public void addLast(LochNess x) {
        StuffNode p = sentinel;
        size += 1;

        /* Move p until it reaches the end of the list*/
        while (p.next != null){
            p = p.next;
        }

        p.next = new StuffNode(x, sentinel, p);
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

    public LochNess removeFirst {
        if (sentinel.next == null) {
            return null;
        } else {
            LochNess prevFirst1 = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size = size-1;
            return prevFirst1;

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


    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10*/
        LLDeque<String> s1 = new LLDeque<String>(); // L is an instance of SLList. it has variable first which points to node with 10 and a variable called size
        s1.addLast("thugs");
        System.out.println(s1.getFirst());
    }
}
