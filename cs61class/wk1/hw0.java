public class drawTriangle {
   public static void drawTriangle(int m) {
      int x = 1;
      int y = 0;
      while (x < m) {
        y = 0;
        while (y < x) {
            System.out.print("*");
            y = y + 1;
        }
        System.out.println();
        x = x + 1;
      } 
   }
   public static void main(String[] args) {
      drawTriangle(10);
      } 
   }