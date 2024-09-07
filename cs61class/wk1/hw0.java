public class ClassNameHere {
   public static void main(String[] args) {
      int x = 1;
      int y = 0;
      while (x < 6) {
        y = 0;
        while (y < x) {
            System.out.print("*");
            y = y + 1;
        }
        System.out.println();
        x = x + 1;
      } 
   }
}