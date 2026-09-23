class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(char c : s1.toCharArray()){
            s1Freq[c-'a']++;
        }

        int l=0,r =s1.length()-1;
        for(char c : s2.substring(l,r+1).toCharArray()){
            s2Freq[c-'a']++;
            }
        while(r<s2.length()-1){
           if(Arrays.equals(s1Freq,s2Freq)) return true;
            s2Freq[s2.charAt(l)-'a']--;
            l++;
            r++;
            s2Freq[s2.charAt(r)-'a']++;
        }

return Arrays.equals(s1Freq, s2Freq);   // check the final window           
    }
}
