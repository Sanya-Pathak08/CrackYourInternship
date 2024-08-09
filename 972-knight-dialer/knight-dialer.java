class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        long[] counts = new long[10];
        Arrays.fill(counts, 1);
        for (int i = 2; i <= n; i++) {
            long[] temp = new long[10];
            temp[0] = (counts[4] + counts[6]) % MOD;
            temp[1] = (counts[6] + counts[8]) % MOD;
            temp[2] = (counts[7] + counts[9]) % MOD;
            temp[3] = (counts[4] + counts[8]) % MOD;
            temp[4] = (counts[0] + counts[3] + counts[9]) % MOD;
            temp[6] = (counts[0] + counts[1] + counts[7]) % MOD;
            temp[7] = (counts[2] + counts[6]) % MOD;
            temp[8] = (counts[1] + counts[3]) % MOD;
            temp[9] = (counts[2] + counts[4]) % MOD;
            counts = temp;
        }
        long totalNumbers = 0;
        for (long value : counts) {
            totalNumbers = (totalNumbers + value) % MOD;
        }
        return (int) totalNumbers;
    }
}