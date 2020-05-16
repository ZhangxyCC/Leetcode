class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if (i != 0 && nums[i] == nums[i - 1])   continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi){        
                if(nums[lo] + nums[hi] + nums[i] == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[lo],nums[hi],nums[i])));
                    while(lo < hi && nums[lo] == nums[lo + 1])  lo++;
                    while(lo < hi && nums[hi] == nums[hi - 1])  hi--;
                    lo++;
                    hi--;
                }else if(nums[lo] + nums[hi] + nums[i] > 0){
                    hi--;
                }else{
                    lo++;
                }
            }
        
        }
        return res;
    }
}
