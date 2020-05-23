class Solution {
    public String frequencySort(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char key : map.keySet()){
            pq.add(new int[]{key-'a', map.get(key)});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            for(int i = 0; i < tmp[1]; i++){
                sb.append((char)(tmp[0] + 'a'));
            }
        }
        return sb.toString();
    }
}