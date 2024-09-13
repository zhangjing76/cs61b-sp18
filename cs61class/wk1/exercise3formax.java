public class ClassNameHere {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int maximum = m[0];
        for (int x = 0; x < (m.length-1); x += 1){
            //check if this is greater than the next value
            if (m[x] >= maximum) {
                //if it is, store it in the variable max
                maximum = m[x];
            }
        }
        return maximum;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
       System.out.println(max(numbers));
    }
}