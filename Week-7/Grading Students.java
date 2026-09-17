import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {
            if (grade < 38) {
                result.add(grade);
            } else {
                int next = ((grade / 5) + 1) * 5;

                if (next - grade < 3) {
                    result.add(next);
                } else {
                    result.add(grade);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        List<Integer> result = gradingStudents(grades);

        for (int x : result) {
            System.out.println(x);
        }
    }
}
Input (stdin)
4
73
67
38
33
Your Output (stdout)
75
67
40
33
