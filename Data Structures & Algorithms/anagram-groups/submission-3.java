class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> lookup = new HashMap<>();

        for (String str : strs){
            int[] code = new int[26];
            for (char ch : str.toCharArray()){
                code[ch - 'a']++;
            }
            String key = Arrays.toString(code);
            lookup.computeIfAbsent(key, k -> new ArrayList<>()).add(str);      
        }

        return new ArrayList<>(lookup.values());

        
    }
}
