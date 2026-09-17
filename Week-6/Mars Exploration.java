import java.io.*;
import java.util.*;

public class Solution {

    public static int marsExploration(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected = "SOS".charAt(i % 3);

            if (s.charAt(i) != expected) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int result = marsExploration(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
Input (stdin)
SOSSPSSQSSOR
Your Output (stdout)
3
