class Solution {
    public boolean isPalindrome(String s) {
        int l = 0; 
        int r = s.length()-1;
        while(l<r){
            char cL = s.charAt(l);
            char cR = s.charAt(r);
            
            boolean lIsAlnum = (cL >= 'A' && cL <= 'Z') || (cL >= 'a' && cL <= 'z') || (cL >= '0' && cL <= '9');
            boolean rIsAlnum = (cR >= 'A' && cR <= 'Z') || (cR >= 'a' && cR <= 'z') || (cR >= '0' && cR <= '9');

            if(!lIsAlnum) l++;
            else if (!rIsAlnum)r--;
            else {
                if (Character.toLowerCase(cL) != Character.toLowerCase(cR)) return false;
                l++;
                r--;
            }
        }

        return true;
        
    }
}
