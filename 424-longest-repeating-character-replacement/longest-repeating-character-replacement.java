class Solution {
    public int characterReplacement(String s, int k) {
       int n = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        
        for (int end = 0; end < n; end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
                maxCount = 0;
                for (int i = 0; i < 26; i++) {
                    maxCount = Math.max(maxCount, count[i]);
                }
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength; 
    }
}