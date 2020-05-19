class Solution {
    public void sortColors(int[] nums) {
        int two_p = nums.length - 1;
        while(two_p >= 0 && nums[two_p] == 2) two_p--;
        int zero_p = 0;
        while(zero_p < nums.length && nums[zero_p] == 0) zero_p++;
        int i = zero_p;
        while(i <= two_p){
            if(nums[i] == 2){
                nums[i] = nums[two_p];
                nums[two_p] = 2;
                two_p--;
            }else if(nums[i] == 0){
                nums[i] = nums[zero_p];
                nums[zero_p] = 0;
                zero_p++;
                i++;
            }else{
                i++;
            }
        }
    }
}