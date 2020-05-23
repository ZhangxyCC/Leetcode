// Priority Queue
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(pq.poll()[0]);
        }
        return res;
    }
    
}

// Bucket Sort
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null)    bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = bucket.length -1; index < k; i--){
            if(bucket[i] == null)   continue;
            for(int r : bucket[i]){
                res[index++] = r;
            }
        }
        return res;
    }
}