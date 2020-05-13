class Solution {
    public void nextPermutation(int[] nums) {
        //find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
        int k = nums.length - 2;
        while(k >= 0){
            if(nums[k] < nums[k + 1]){
                break;
            }
            k--;
        }
        if(k == -1){
            //reverse nums
            Arrays.sort(nums);
            return;
        }
        //find the largest index l > k such that nums[k] < nums[l].
        int l = nums.length - 1;
        while(l > k){
            if(nums[l] > nums[k]){
                break;
            }
            l--;
        }
        //Swap nums[k] and nums[l]
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
        //Reverse the sub-array nums[k + 1:].
        for(int i = 0; i < (nums.length - k - 1) / 2; i++){
            temp = nums[i + k + 1];
            nums[i + k + 1] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        
    }
}