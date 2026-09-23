class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) return false;

        int[] s1Freq = new int[26];
        for(char c : s1.toCharArray()){
            s1Freq[c-'a']++;
        }

        int l=0,r =s1.length()-1;
        while(r<s2.length()){
            int[] s2Freq = new int[26];
            for(char c : s2.substring(l,r+1).toCharArray()){
            s2Freq[c-'a']++;}
            if(Arrays.equals(s1Freq,s2Freq)) return true;
            l++;
            r++;
        }

        return false;
        
    }
}
