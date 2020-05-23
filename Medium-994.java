class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited.add(i * n + j);
                }
                if(grid[i][j] != 0) num++;
            }
        }
        int time = 0;
        while(!queue.isEmpty()){
            time++;
            int size = queue.size();
            System.out.println(size);
            num -= size;
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                visited.add(tmp[0] * n + tmp[1]);
                if(checkValue(m, n, tmp[0] - 1, tmp[1], grid) && !visited.contains((tmp[0] - 1) * n + tmp[1])){
                    queue.add(new int[]{tmp[0] - 1, tmp[1]});
                    visited.add((tmp[0] - 1) * n + tmp[1]);
                }
                if(checkValue(m, n, tmp[0] + 1, tmp[1], grid) && !visited.contains((tmp[0] + 1) * n + tmp[1])){
                    queue.add(new int[]{tmp[0] + 1, tmp[1]});
                    visited.add((tmp[0] + 1) * n + tmp[1]);
                }
                if(checkValue(m, n, tmp[0], tmp[1] - 1, grid) && !visited.contains((tmp[0]) * n + tmp[1] - 1)){
                    queue.add(new int[]{tmp[0], tmp[1] - 1});
                    visited.add((tmp[0]) * n + tmp[1] - 1);
                }
                if(checkValue(m, n, tmp[0], tmp[1] + 1, grid) && !visited.contains((tmp[0]) * n + tmp[1] + 1)){
                    queue.add(new int[]{tmp[0], tmp[1] + 1});
                    visited.add((tmp[0]) * n + tmp[1] + 1);
                }
            }
        }
        if(num != 0)    return -1;
        if(time == 0)   return 0;
        return time - 1;
    }
    
    private boolean checkValue(int m, int n, int i, int j, int[][] grid){
        if(i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1)  return true;
        return false;
    }
}