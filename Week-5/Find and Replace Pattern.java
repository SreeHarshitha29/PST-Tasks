class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);

        for (int i = 0; i < word.length(); i++) {
            int a = word.charAt(i) - 'a';
            int b = pattern.charAt(i) - 'a';

            if (map1[a] == -1 && map2[b] == -1) {
                map1[a] = b;
                map2[b] = a;
            } else if (map1[a] != b || map2[b] != a) {
                return false;
            }
        }

        return true;
    }
}
#Input
words = ["abc","deq","mee","aqq","dkd","ccc"]
pattern = "abb"
#Output
["mee","aqq"]
