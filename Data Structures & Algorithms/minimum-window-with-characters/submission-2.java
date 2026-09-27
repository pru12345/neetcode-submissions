class Solution {
    public String minWindow(String s, String t) {
        // shortest substring of s
        //t can contains duplicates 

        //ALGO
        //using hash maps to calculate the freq
        ////maintain the have and needed variables to know weather we have required chars.
        
        Map<Character,Integer> have_map = new HashMap<>();
        Map<Character,Integer> need_map = new HashMap<>();

       
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for(char ch : t.toCharArray()){
            need_map.put(ch, need_map.getOrDefault(ch,0) +1);
        }
        int need =  need_map.size();
        int have =0;

        int l =0;
        for(int r=0; r<s.length(); r++ ){
            char ch = s.charAt(r);
            have_map.put(ch, have_map.getOrDefault(ch, 0) + 1);


            if(need_map.containsKey(ch)&&need_map.get(ch).equals(have_map.get(ch))){
                have++;
            }

            while( have == need ){
                if((r-l+1)<resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
           
                have_map.put(leftChar,have_map.get(leftChar)-1 );

                if(need_map.containsKey(leftChar)&& need_map.get(leftChar)> have_map.get(leftChar)){

                have--;
                }
                l++;
            }


        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
        
    }