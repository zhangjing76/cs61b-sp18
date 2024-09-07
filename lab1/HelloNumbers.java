public class HelloNumbers {
    public static void main(String[] args) {
        int sum = 0; //0 1 2 3 4 5 6 7 8 9; 0, 1, 3, 6, 10...45
        int x = 0;
        while (x < 10) { //while the integer is less than 10
            //add x to the sum
            sum = sum + x;
            System.out.print(sum + "\n");
            x = x + 1;
        }
    }
}