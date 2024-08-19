class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int start, int end) {
        // check end point
        if (start >= end) return 0;
        
        // for each index i in nums, need to cover [i+1, ... n-1] to satisfy `reverse pair` rule
        // divide and conquer [i ~ n] into 2 sections:
        // 1) solve subProblem(start,mid) & subProblem(mid+1, end), 2) cover the rest range: for all [i, mid], check against [mid+1, end].
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        // count pair
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) j++; // `num/2.0` to avaoid overflow
            count += j - (mid + 1); // use index i (ahead of mid point) to compare all elements after mid point
        }
        
        Arrays.sort(nums, start, end + 1); // partial sort of range [start, end] inclusively
        
        return count;
    }
}