
import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("CreditCard %.2f%n", amount);
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("UPI %.2f%n", amount);
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("NetBanking %.2f%n", amount);
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        double fee = 0;

        if (payment instanceof CreditCardPayment) {
            fee = amount * 0.02;
        } else if (payment instanceof UPIPayment) {
            fee = amount * 0.01;
        } else if (payment instanceof NetBankingPayment) {
            fee = amount * 0.015;
        }

        return amount + fee;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        OnlinePaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < N; i++) {
            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            String type;

            if (paymentType == 1) {
                payment = new CreditCardPayment();
                type = "CreditCard";
            } else if (paymentType == 2) {
                payment = new UPIPayment();
                type = "UPI";
            } else {
                payment = new NetBankingPayment();
                type = "NetBanking";
            }

            double finalAmount = processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n", type, finalAmount);
        }

        sc.close();
    }
}

#Input
  3
1 1000
2 2000
3 5000
#Output
  CreditCard 1020.00
   UPI 2020.00
  NetBanking 5075.00
