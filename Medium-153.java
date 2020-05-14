// way 1 compare mid and high
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] < nums[hi]){
                hi = mid;
            }
            else if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }
        }
        
        return nums[lo];
    }
}
// way2: compare mid and start
class Solution {
    public int findMin(int[] num) {
        int start=0;
        int end=num.length - 1;
        
        while (start<end) {
            if (num[start]<num[end])
                return num[start];
            
            int mid = (end - start)/2 + start;
            
            if (num[mid]>=num[start]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        
        return num[start];
    }
}
