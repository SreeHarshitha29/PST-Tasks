
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.println("Enter marks:");
        for (int i = 0; i < n; i++) {
            marks.add(sc.nextInt());
        }

        System.out.println("Marks: " + marks);

        if (n > 0) {
            int highest = Collections.max(marks);
            double average = 0;

            for (int mark : marks)
                average += mark;

            average /= n;

            System.out.println("Highest mark: " + highest);
            System.out.printf("Average: %.2f%n", average);
        }

        sc.close();
    }
}

#Input
  5
78
85
92
67
88
  #Output
  Enter number of students: Enter marks:
Marks: [78, 85, 92, 67, 88]
Highest mark: 92
Average: 82.00
