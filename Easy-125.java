class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        System.out.println(s);
        int p1 = 0;
        int p2 = s.length() - 1;
        while(p1 < p2){
            while(p1 < s.length() && !Character.isLetterOrDigit(s.charAt(p1)))  p1++;
            while(p2 >= 0 && !Character.isLetterOrDigit(s.charAt(p2)))  p2--;
            if(p1 >= s.length() || p2 < 0)  return true;
            if(s.charAt(p1) != s.charAt(p2))    {
                System.out.println(p1 + " " + p2);
                return false;
            }
            else{
                p1++;
                p2--;
            }
        }
        return true;
    }
}