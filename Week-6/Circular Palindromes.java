import java.io.*;
import java.util.*;

public class Solution {

    static int[] tree;
    static int size;

    static void manacher(char[] s, int[] p) {
        int center = 0, right = 0;

        for (int i = 0; i < s.length; i++) {
            if (i < right) {
                p[i] = Math.min(right - i, p[2 * center - i]);
            }

            while (i - p[i] - 1 >= 0 &&
                   i + p[i] + 1 < s.length &&
                   s[i - p[i] - 1] == s[i + p[i] + 1]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }

    static void build(int[] arr) {
        size = 1;
        while (size < arr.length) {
            size <<= 1;
        }

        tree = new int[size << 1];

        for (int i = 0; i < arr.length; i++) {
            tree[size + i] = arr[i];
        }

        for (int i = size - 1; i > 0; i--) {
            tree[i] = Math.max(tree[i << 1], tree[i << 1 | 1]);
        }
    }

    static int query(int l, int r) {
        if (l > r) {
            return 0;
        }

        l += size;
        r += size;

        int ans = 0;

        while (l <= r) {
            if ((l & 1) == 1) {
                ans = Math.max(ans, tree[l++]);
            }

            if ((r & 1) == 0) {
                ans = Math.max(ans, tree[r--]);
            }

            l >>= 1;
            r >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        String doubled = s + s;

        int len = 4 * n + 1;
        char[] transformed = new char[len];

        Arrays.fill(transformed, '#');

        for (int i = 0; i < 2 * n; i++) {
            transformed[2 * i + 1] = doubled.charAt(i);
        }

        int[] p = new int[len];

        manacher(transformed, p);
        build(p);

        StringBuilder out = new StringBuilder();

        for (int start = 0; start < n; start++) {
            int left = 2 * start + 1;
            int right = 2 * (start + n - 1) + 1;

            int low = 1;
            int high = n;
            int answer = 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                int l = left + mid - 1;
                int r = right - mid + 1;

                if (l <= r && query(l, r) >= mid) {
                    answer = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }
}
Input (stdin)
13
aaaaabbbbaaaa
Your Output (stdout)
12
12
10
8
8
9
11
13
11
9
8
8
10
