public class ClassNameHere {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int x = 0;
        int maximum = m[0];
        while (x < m.length-1){
            //check if this is greater than the next value
            if (m[x] >= maximum) {
                //if it is, store it in the variable max
                maximum = m[x];
            }
            x = x + 1;
        }
        return maximum;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
       System.out.println(max(numbers));
    }
}