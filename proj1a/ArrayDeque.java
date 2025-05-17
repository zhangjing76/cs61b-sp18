public class ArrayDeque<T> {
    /** An ArrayDeque is a list. Circular */
    private int size;
    private T[] items;
    private int RFACTOR = 2;
    private int start;
    private int end;

    /**New empty LinkedListDeque (constructor) */
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        start = 0;
        end = 0;
    }

    /** Adds x to the front of the list.  */
    public void addFirst(T x){
        if (size == items.length){
            resize(items.length * RFACTOR);
        }
        if (size == 0){
            start = 0;
            items[0] = x;
            end = 0;
        }
        //addFirst and front pointer is at 0
        else if (start == 0){ //what if there is something else at the end
            items[items.length-1] = x; //start is at end of array now
            //changing start
            start = items.length-1;
        }
        else if (start > end){ //split
            items[start - 1] = x;
            start -= 1;
        }
        else { //normal
            items[start-1] = x;
            start = 0;
        }
        size +=1;
    }

    /**Resizes array if not long enough*/
    private void resize(int newSize){ //resizing sets everything back to normal. need to resizedown too
        T[] a = (T[]) new Object[newSize]; //generic array
        if (start == 0){
            System.arraycopy(items, start, a, 0, size);
        }
        else{
            System.arraycopy(items, start, a, 0, items.length-start); //
            System.arraycopy(items, 0, a, items.length-start, end+1); //copy separate end

        }
        items = a;
        start = 0;
        end = size-1;
    }

    /**Resizes array down if usage is less than 25%*/
    private void resizeDown(int newSize){
        T[] a = (T[]) new Object[newSize]; //generic array
        if (start == 0 || end != items.length-1){ //together
            System.arraycopy(items, start, a, 0, size);
        }
        else{
            System.arraycopy(items, start, a, 0, items.length-start); //
            System.arraycopy(items, 0, a, items.length-start, end+1); //copy separate end
        }

        items = a;
        start = 0;
        end = size-1;
    }

    /** Adds x to the end of the list.  */
    public void addLast(T x){
        if (size == 0) {
            start = 0;
            items[0] = x;
            end = 0;
        }
        else if (size == items.length){
            resize(items.length * RFACTOR);
        }
        else if (end == items.length-1){
            items[0] = x;
            end = 0;
        }
        else {
            items[end + 1] = x; //works even if split
            end += 1;
        }

        size+=1;
    }

    /**Checks is list is empty*/
    public boolean isEmpty(){
        return size == 0;
    }

    /**Prints size*/
    public int size(){
        return size;
    }

    /**Prints entire Deque from front to back*/
    public void printDeque(){
        if (start == 0){
            for (int i = 0; i < size; i++){
                System.out.println(items[i]);
            }
        }
        else{ //split
            for (int i = start; i <= items.length-1; i++){
                System.out.println(items[i]);
            }
            for (int i = 0; i <= end; i++){
                System.out.println(items[i]);
            }
        }
    }

    /**Removes the first value of the list. Null out deleted items!*/
    public T removeFirst(){
        System.out.println((double) size/items.length);
        if ((double) size/items.length <= 0.25 && items.length >= 16){
            resizeDown((items.length+2)/4); //always round down (so we add 1)
        }
        if (size == 0){
            return null;
        }
        //change start
        T prevFirst = items[start];
        items[start] = null; //don't loiter
        size -=1;
        if (start == items.length-1){
            start = 0;
        }
        else {
            start +=1;
        }
        return prevFirst;
    }

    /** removes last value of list. Don't loiter!*/
    public T removeLast(){
        if ((double) size /items.length <=0.25 && items.length >=16){
            resizeDown((items.length+1)/4); //always round down (so we add 1)
        }
        if (size == 0){
            return null;
        }
        T prevLast = items[end];
        items[end] = null; //don't loiter
        if (end == 0){
            end = items.length-1;
        }
        else{
            end -=1;
        }
        size -= 1;
        return prevLast;
    }

    /**Gets item at index using iteration*/
    public T get(int index){ //faulty/ how to make take constant time  if split?
        int desired;
        desired = (start+index+1)%items.length;
        return items[desired-1];
    }

    public static void main (String[]args){
        ArrayDeque<Integer> L = new ArrayDeque();
        System.out.println(L.isEmpty());
    }
}
