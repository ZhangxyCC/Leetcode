class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0 || s1.length() > s2.length())  return false;
        
        int[] chars = new int[26];
        for(char c : s1.toCharArray()){
            chars[c - 'a']++;
        }
        int len = s1.length();
        
        int end= 0;
        int start = 0;
        for(end = 0; end < s1.length(); end++){
            if(chars[s2.charAt(end) - 'a'] > 0){
                len--; 
            }
            chars[s2.charAt(end) - 'a']--;
        }
    
        if(len==0)  return true;
    
        while(end<s2.length()){
        
            if(chars[s2.charAt(start) - 'a'] >= 0)  len++;
            chars[s2.charAt(start) - 'a']++;
            start++;
            chars[s2.charAt(end)-'a']--;
            
            if (chars[s2.charAt(end)-'a'] >= 0) len--;
            
            if (len == 0)    return true;
            end++;
        }
        return false;
    }
}