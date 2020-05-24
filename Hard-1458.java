class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            dp[i][0] = Math.max(nums1[i] * nums2[0], max1);
            max1 = dp[i][0];
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = Math.max(nums1[0] * nums2[j], max2);
            max2 = dp[0][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int temp1 = Math.max(dp[i - 1][j], dp[i][j - 1]);
                int temp2 = nums1[i] * nums2[j] + dp[i - 1][j - 1];
                dp[i][j] = Math.max(temp1, temp2);
            }
        }
        return dp[m -1][n-1];
    }
   
}