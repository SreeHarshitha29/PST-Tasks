import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(a / b);
        }
        catch (InputMismatchException e) {
            System.out.println(e);
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
Input (stdin)
2147483648
2147483648
Your Output (stdout)
java.util.InputMismatchException: For input string: "2147483648"
