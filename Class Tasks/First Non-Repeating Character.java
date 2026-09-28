import java.util.HashMap;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str.toCharArray()) {
            if (frequency.get(ch) == 1) {
                System.out.println(ch);
                sc.close();
                return;
            }
        }

        System.out.println(-1);

        sc.close();
    }
}
#Input:
swiss
#Output:
w
