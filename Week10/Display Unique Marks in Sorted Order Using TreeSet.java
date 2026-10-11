
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> marks = new TreeSet<>();

        System.out.print("Enter number of marks: ");
        int n = sc.nextInt();

        System.out.println("Enter marks:");
        for (int i = 0; i < n; i++) {
            marks.add(sc.nextInt());
        }

        System.out.println("Sorted unique marks: " + marks);

        sc.close();
    }
}
#Input
6
80 65 90 80 75 65
  #Output
  Sorted unique marks: [65, 75, 80, 90]
