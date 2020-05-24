class Solution {
    public int maxVowels(String s, int k) {
        
        HashSet<Character> set = new HashSet<>(Arrays. asList('a', 'e','i','o','u'));
        
        int count = 0;
        for(int i=0;i<k;i++){
            if(set.contains(s.charAt(i)))   count++;
        }
        int max = count;
        for(int i = k; i < s.length(); i++){
            if(set.contains(s.charAt(i - k)))   count--;
            if(set.contains(s.charAt(i)))   count++;
            if(count > max) max = count;
        }
        return max;
    }
}