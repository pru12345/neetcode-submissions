class Solution {
    public int characterReplacement(String s, int k) {
        //uppercase english characters 
        //k Chars and replace them with other uppercase English character.

        int l =0, r =0, result =0 ;
        HashMap<Character, Integer> freq = new HashMap<>();

        int maxFreq = 0;

        while(r<s.length()){
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq,freq.get(c));
            if( r-l+1 - maxFreq > k){
                char left = s.charAt(l);
                freq.put(left,freq.get(left) - 1);
                l++;
                }

                result= Math.max(result,r-l+1);
                r++;
            }

            return result;
        }
        
    }
