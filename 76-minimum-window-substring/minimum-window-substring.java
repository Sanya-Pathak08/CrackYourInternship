class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        int required = tCount.size();
        int left = 0, right = 0, formed = 0;
        int windowCounts[] = new int[128];
        int minLen = Integer.MAX_VALUE, minLeft = 0, minRight = 0;
        
        while (right < s.length()) {
            char character = s.charAt(right);
            windowCounts[character]++;
            if (tCount.containsKey(character) && windowCounts[character] == tCount.get(character)) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                character = s.charAt(left);
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                
                windowCounts[character]--;
                if (tCount.containsKey(character) && windowCounts[character] < tCount.get(character)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }
}