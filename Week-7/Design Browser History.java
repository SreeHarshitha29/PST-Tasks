import java.util.*;

class BrowserHistory {

    List<String> history = new ArrayList<>();
    int current = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }

        history.add(url);
        current++;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }
}
Input
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
Output
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
