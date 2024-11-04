public class Sort {
    public static String[] sort(String[] x) {
        //find the smallest item
        //move it to the front
        //selection sort the rest (using recursion??)

        int smallestIndex = findSmallest(x, 0);
        swap(x, 0,  smallestIndex);
        sort(x, 0);
        return x;
    }

    /** Sorts x starting at position start. */
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /** Return the index of the smallest String in x starting from start*/
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            // from the internet, if x[i] < x[smallestIndex], cmp will be -1
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /** Swap item a with b*/
    public static void swap(String[] x, int a, int b) {
        String temp= x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}