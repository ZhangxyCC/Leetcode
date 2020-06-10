// BFS
class Solution {
   
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<Integer> path = new ArrayList<>();
         ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int[] p : prerequisites){
            if(graph[p[1]] == null) graph[p[1]] = new ArrayList<>();
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
                path.add(i);
            } 
        }
        while(!queue.isEmpty()){
            int p = queue.poll();
            count++;
            if(graph[p] == null)    continue;
            for(int j : graph[p]){
                indegree[j]--;
                if(indegree[j] == 0)   {
                    queue.add(j);
                    path.add(j);
                } 
            }
        }
        if(count != numCourses) return new int[0];
        int[] res = new int[numCourses];
        for(int i = 0 ;i  < numCourses; i++){
            res[i] = path.get(i);
        }
        return res;
    }
   
}