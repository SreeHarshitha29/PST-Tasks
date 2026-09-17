import java.io.*;
import java.util.*;

public class Solution {

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {

                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }

                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }

                return -1;
            }

            left++;
            right--;
        }

        return -1;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < q; i++) {
            String s = bufferedReader.readLine();

            int result = palindromeIndex(s);

            System.out.println(result);
        }

        bufferedReader.close();
    }
}

Input (stdin)
3
aaab
baa
aaa
Your Output (stdout)
3
0
-1
