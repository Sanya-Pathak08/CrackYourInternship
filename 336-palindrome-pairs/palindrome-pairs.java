public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordDict = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            wordDict.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                String suffix = words[i].substring(j);
                
                if (isPalindrome(suffix)) {
                    String revPrefix = new StringBuilder(prefix).reverse().toString();
                    if (wordDict.containsKey(revPrefix) && wordDict.get(revPrefix) != i) {
                        result.add(Arrays.asList(i, wordDict.get(revPrefix)));
                    }
                }
                
                if (j > 0 && isPalindrome(prefix)) {
                    String revSuffix = new StringBuilder(suffix).reverse().toString();
                    if (wordDict.containsKey(revSuffix) && wordDict.get(revSuffix) != i) {
                        result.add(Arrays.asList(wordDict.get(revSuffix), i));
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}