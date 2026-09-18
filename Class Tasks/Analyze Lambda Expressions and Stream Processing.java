import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> marks = Arrays.asList(45, 78, 32, 90, 65, 88, 40, 95);

        List<Integer> updatedMarks = marks.stream()
                .filter(mark -> mark >= 60)
                .map(mark -> mark + 5)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Updated marks in descending order:");
        updatedMarks.forEach(mark -> System.out.println(mark));

        double average = updatedMarks.stream()
                .mapToInt(mark -> mark)
                .average()
                .orElse(0.0);

        System.out.println("Average: " + average);
    }
}
#Output
Updated marks in descending order:
  100
  95
  93
  83
  70
  Average: 88.2
