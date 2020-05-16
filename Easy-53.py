class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        tmp_max = nums[0]
        res = nums[0]
        for i in range(1, len(nums)):
            if nums[i] + tmp_max > nums[i]:
                tmp_max +=  nums[i]
                res = max(res, tmp_max)
            else:
                res = max(res, nums[i])
                tmp_max = nums[i]
        return int(res)