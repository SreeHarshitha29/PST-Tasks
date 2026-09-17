import java.util.*;

abstract class Vehicle {
    abstract int fare(int distance);
}

class Bike extends Vehicle {
    int fare(int distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    int fare(int distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    int fare(int distance) {
        return distance * 12;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            String type = sc.next();
            int distance = sc.nextInt();

            try {
                Vehicle v;

                if (type.equals("Bike"))
                    v = new Bike();
                else if (type.equals("Auto"))
                    v = new Auto();
                else if (type.equals("Cab"))
                    v = new Cab();
                else
                    throw new Exception();

                System.out.println(v.fare(distance));

            } catch (Exception e) {
                System.out.println("Invalid Booking");
            }
        }
    }
}

## Input & output 
  3
Bike 10
50
Cab 15
180
Auto 80
960
  
  
