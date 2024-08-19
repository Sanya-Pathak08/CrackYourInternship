class NumArray {
    private int[] nums;
    private int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            updateTree(i, nums[i]);
        }
    }
    
    private void updateTree(int index, int val) {
        index++;
        while (index < tree.length) {
            tree[index] += val;
            index += index & -index;
        }
    }
    
    private int queryTree(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateTree(index, diff);
    }
    
    public int sumRange(int left, int right) {
        return queryTree(right) - queryTree(left - 1);
    }
}