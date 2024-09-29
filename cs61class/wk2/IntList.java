public class IntList {
    public int first;
    public IntList rest; //pointer to next element in list

    //this doesnt have SLList that points to first node. This only uses nodes. 
    //hard to implement addFirst because there is no first pointer 

    public IntList(int f, IntList r) { //constructor = how you start the ojbect
        first = f; 
        rest = r;
    }

    //finding the size in IntList is harder because there is no middle man (SLList class) 
    //doing it like the ways below is time consuming
    //but if you create a variable called size for each node, it is more time consuming.
    //because if you add a new node, you have to change size for all the nodes.
    //in SLList, we could just use size in SLList L's data.

    /**Return the size of the list using recursion */
    public int size() { //method
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /**Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /**Returns ith item in the list */
    public int get(int i) {
        IntList p = this;
        int item = 1;
        while (item <= i) {
            item += 1;
            p = p.rest;
        }
        return p.first;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.get(0));

        /*
        above does the same as below but backwards.
        L.rest = new IntList();
        L.rest.first = 10;

        L.rest.rest = new IntList();
        L.rest.rest.first = 15;
        */
    }
}