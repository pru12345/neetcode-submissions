class Solution {
    //set it
    //find start of the sequence, add a variable to get the max seq
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) set.add(num);
        int max = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                //start of seq
                int p = num;
                int len = 0;
                while(set.contains(p)){
                    len++;
                    p++;
                }
                max = Math.max(len,max);
            }

        }
        return max;
    }
}
