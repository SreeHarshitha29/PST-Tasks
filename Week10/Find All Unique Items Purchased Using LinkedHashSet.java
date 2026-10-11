
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> items = new LinkedHashSet<>();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        System.out.println("Enter items:");
        for (int i = 0; i < n; i++) {
            items.add(sc.next());
        }

        System.out.println("Unique items: " + items);

        sc.close();
    }
}
#Input
  5
Pen Book Pen Bag Book
  #Output
  Unique items: [Pen, Book, Bag]
