
import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        HashMap<Integer, Product> productMap = new HashMap<>();
        PriorityQueue<Integer> orders = new PriorityQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();

            Product p = new Product(id, name, price);
            products.add(p);
            productMap.put(id, p);
        }

        System.out.println("Products:");
        for (Product p : products)
            System.out.println(p);

        System.out.print("Enter product ID to search: ");
        int searchId = sc.nextInt();

        if (productMap.containsKey(searchId))
            System.out.println(productMap.get(searchId));
        else
            System.out.println("Product not found");

        System.out.print("Enter number of orders: ");
        int m = sc.nextInt();

        System.out.println("Enter order priorities:");
        for (int i = 0; i < m; i++)
            orders.offer(sc.nextInt());

        System.out.println("Orders by priority:");
        while (!orders.isEmpty())
            System.out.println(orders.poll());

        sc.close();
    }
}
#Input
3
101 Laptop 55000
102 Mouse 500
103 Keyboard 1500
102
3
2
1
3
  #Output
  Products:
101 Laptop 55000.0
102 Mouse 500.0
103 Keyboard 1500.0
Enter product ID to search: 102 Mouse 500.0
Enter number of orders: Enter order priorities:
Orders by priority:
1
2
3
