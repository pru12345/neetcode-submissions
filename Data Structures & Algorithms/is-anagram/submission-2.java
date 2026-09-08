class Solution {
    // Lowercase 97 to 122
    //UpperCase 65 to 90
    public boolean isAnagram(String s, String t) {
        int[] s_array = new int[26];
        int[] t_array = new int[26];

        for (char ch : s.toCharArray()){
            s_array[Character.toLowerCase(ch)-97]++;
        }

        for (char ch : t.toCharArray()){
            t_array[Character.toLowerCase(ch)-97]++;
        }

        return Arrays.equals(s_array,t_array);

    }
}
