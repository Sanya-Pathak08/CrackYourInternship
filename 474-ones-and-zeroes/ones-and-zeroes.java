class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = countZeros(str);
            int ones = str.length() - zeros;

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int countZeros(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    }
}