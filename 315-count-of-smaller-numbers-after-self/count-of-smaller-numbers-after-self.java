class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }
        
        Arrays.sort(sortedNums);
        
        int[] bit = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = Arrays.binarySearch(sortedNums, nums[i]);
            res.add(0, query(bit, idx));
            update(bit, idx + 1, 1);
        }
        
        return res;
    }
    
    private void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i;
        }
    }
    
    private int query(int[] bit, int i) {
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= i & -i;
        }
        return res;
    }
}