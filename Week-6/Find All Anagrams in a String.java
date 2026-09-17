import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int k = p.length();

        for (int i = 0; i < s.length(); i++) {
            windowCount[s.charAt(i) - 'a']++;

            if (i >= k) {
                windowCount[s.charAt(i - k) - 'a']--;
            }

            if (i >= k - 1 && Arrays.equals(pCount, windowCount)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}

Input
s = "cbaebabacd"
p = "abc"
Output
[0,6]
