import java.util.HashMap;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (int num : frequency.keySet()) {
            System.out.println(num + " -> " + frequency.get(num));
        }

        sc.close();
    }
}
#Input:
8
2 3 2 5 3 2 4 5

#Output:
2 -> 3
3 -> 2
5 -> 2
4 -> 1
