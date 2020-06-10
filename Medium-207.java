// DFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int[] p : prerequisites){
            if(graph[p[1]] == null) graph[p[1]] = new ArrayList<>();
            graph[p[1]].add(p[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses;i++){
            if(!visited.contains(i)){
                if(!helper(numCourses, graph, visited, i))  return false;
            }
        }
        return true;
    }
    
    private boolean helper(int numCourses, ArrayList<Integer>[] graph, HashSet<Integer> visited, int i){
        if(graph[i] == null)    return true;
        visited.add(i);
        for(int j : graph[i]){
            if(!visited.contains(j)){
                if(!helper(numCourses, graph, visited, j))  return false;
            }else   return false;
        }
        visited.remove(i);
        return true;
    }
}

//BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            if(indegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int p = queue.poll();
            count++;
            if(graph[p] == null)    continue;
            for(int j : graph[p]){
                indegree[j]--;
                if(indegree[j] == 0)    queue.add(j);
            }
        }
        return count == numCourses;
    }
}