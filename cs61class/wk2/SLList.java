/** An SLList is a list, */
public class SLList<LochNess> {
    private class StuffNode { //can be made private if we wanted
        public LochNess item;
        public StuffNode next; //pointer to next element in list
        public StuffNode(LochNess i, StuffNode n) { //constructor = how you start the ojbect
            item = i; 
            next = n;
        }
    }

    public int size() {
            return size;
    }
    // The first item (if it exists) is  at sentinel.next
    private StuffNode sentinel; //sentinel is a pointer node;   , points to StuffNode instance
    private int size; //this variable belongs to SLList L.

    public SLList(LochNess x) {
        sentinel = new StuffNode(x, null); //sentinel is a pointer to the sentinel
        sentinel.next = new StuffNode(x, null); //first point to instance of StuffNode
        size = 1;
    }
    //L only has first as its data. it is not an StuffNode is it a SLList

    /**New empty SLList */
    public SLList() {
        sentinel = new StuffNode(null, null);
        size = 0;
    }
    
    /** Adds x to the front of the list.  */
    public void addFirst(LochNess x) {
            sentinel.next = new StuffNode(x, sentinel.next);
            //first = new StuffNode(x, first);
            size += 1;
    }

    /** Returns the first item in the list */
    public LochNess getFirst() { //can still use first because it is not a class, it is a method
            return sentinel.next.item;
    }

    /** Adds an item to the end of the list.  */
    public void addLast(LochNess x) {
            StuffNode p = sentinel;
            size += 1;

            /* Move p until it reaches the end of the list*/
            while (p.next != null){
                p = p.next;
            }

            p.next = new StuffNode(x, null);
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10*/
        SLList<String> s1 = new SLList<String>(); // L is an instance of SLList. it has variable first which points to node with 10 and a variable called size
        s1.addLast("thugs");
        System.out.println(s1.getFirst());
    }
}