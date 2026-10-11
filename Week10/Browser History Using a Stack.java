
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();

        history.push("Google");
        history.push("YouTube");
        history.push("HackerRank");
        history.push("GitHub");

        System.out.println("Browser History: " + history);

        System.out.println("Back button: " + history.pop());

        System.out.println("Updated History: " + history);
    }
}
#Output
  Browser History: [Google, YouTube, HackerRank, GitHub]
Back button: GitHub
Updated History: [Google, YouTube, HackerRank]
  
  
