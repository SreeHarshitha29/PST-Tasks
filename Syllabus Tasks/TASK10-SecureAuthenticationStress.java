import java.util.*;

public class Authetication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            String username = sc.next();
            String password = sc.next();

            if (username.length() >= 3 && username.length() <= 20 &&
                password.length() >= 6 && password.length() <= 20 &&
                username.equals("admin") &&
                password.equals("admin123")) {

                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILURE");
            }
        }
    }
}
# Input & Output 
  3
  admin admin123
  SUCCESS
  ab 123
  FAILURE
  user pass
  FAILURE
