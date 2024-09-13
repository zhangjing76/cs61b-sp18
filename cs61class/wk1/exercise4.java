public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /** your code here */ 
    //replace each elemt a[i] with sum of a[i] through a[i+n] only if a[i] is positive
    //only su m as many values as we have if n is too large
    int x = 0;
    for (int i = 0; i < (a.length); i += 1){
        if (a[i] > 0){
            x = i + 1;
            while ((x < (a.length)) && (x <= (i+n))){
                System.out.println("a[x] = " + a[x] + " i = " + i);
                a[i] = a[i] + a[x];
                x = x + 1;
            }
        }
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}