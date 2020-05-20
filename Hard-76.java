class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int min_len = Integer.MAX_VALUE;
        int min_index = -1;
        int start = 0; 
        int end = 0;
        while(end < s.length()){
            if(map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                if(map.get(s.charAt(end)) == 0) count--;
            }
            end++;
            while(count==0){
                if(map.containsKey(s.charAt(start))){
                    if(map.get(s.charAt(start)) == 0) count++;
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);                
                }
                if(end - start < min_len){
                    min_len = end - start;
                    min_index = start;
                }
                start++;
            }
        }
        if(min_index == -1) return "";
        return s.substring(min_index, min_index + min_len);
    }
}