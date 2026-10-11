
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[2];
        int size = 0;

        System.out.println("Enter marks (-1 to stop):");

        while (true) {
            int mark = sc.nextInt();

            if (mark == -1)
                break;

            if (size == marks.length) {
                marks = Arrays.copyOf(marks, marks.length * 2);
            }

            marks[size++] = mark;
        }

        System.out.println("Student marks:");
        for (int i = 0; i < size; i++) {
            System.out.println(marks[i]);
        }

        sc.close();
    }
}

#Input
  85
90
78
95
-1
  #Output
  Enter marks (-1 to stop):
Student marks:
85
90
78
95
