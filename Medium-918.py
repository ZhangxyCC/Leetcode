class Solution:
    def maxSubarraySumCircular(self, A: List[int]) -> int:
        cur_min = 0
        cur_max = 0
        total_min = float('inf')
        total_max = -float('inf')
        total = 0
        for a in A:
            total += a
            cur_max= max(cur_max + a, a)
            total_max = max(cur_max, total_max)
            cur_min = min(cur_min + a, a)
            total_min = min(cur_min, total_min)
        return max(total_max, total - total_min) if total_max > 0 else total_max
            
            
                
            