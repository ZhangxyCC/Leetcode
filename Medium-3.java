class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 1;
        while(end < s.length()){
            char tmp = s.charAt(end);
            if(!map.containsKey(tmp)){
                map.put(tmp, end);    
            }else{
                start = Math.max(map.get(tmp) + 1, start);
                map.put(tmp, end);
                
            } 
            max = Math.max(end - start + 1, max);
            end++;
        }
        return max;
        
    }
}