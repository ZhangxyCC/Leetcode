// DP
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0)   continue;
                matrix[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]) + 1;
                res += matrix[i][j];
            }
        }
        for(int j = 0; j < n; j++){
            res += matrix[0][j];
        }
        for(int i = 1; i < m; i++){
            res += matrix[i][0];
        }
        return res;
    }
}