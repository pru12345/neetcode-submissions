class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int l =0;
        int r =0;
        int result = 0;

        while(r<s.length()){
            if(!set.contains(s.charAt(r))){
                result = Math.max(result, r-l+1);
                set.add(s.charAt(r));
                r++;
            }else{
                set.remove(s.charAt(l));
                l++;
            }

        }
        return result;
    }
}
