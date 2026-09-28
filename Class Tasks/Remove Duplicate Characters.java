import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        StringBuilder result = new StringBuilder();

        for (char ch : set) {
            result.append(ch);
        } 
#Input:
programming

#Output:
progamin
