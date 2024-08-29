class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
            else j++;
        }
        for (int c=nums.length-1;j>0;c--){
            nums[c]=0;
            j--;
        }
    }
}