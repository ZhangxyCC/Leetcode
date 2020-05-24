# from Lee215
class Solution(object):
    def maxDotProduct(self, A, B):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        if all(a < 0 for a in A) and (b > 0 for b in B):
            return max(A) * min(B)
        if all(a > 0 for a in A) and (b < 0 for b in B): 
            return min(A) * max(B)

        n,m = len(A), len(B)
        dp = [[0] * (m + 1) for i in xrange(n + 1)]
        
        for i in xrange(1, n+1):
            for j in xrange(1, m+1):
                dp[i][j] = max(dp[i-1][j], dp[i][j-1],dp[i-1][j-1] + A[i-1]*B[j-1])
        print(dp)
        return dp[n][m]
        