class Solution {
    public boolean hasDuplicate(int[] nums) {
        // HashSet<Integer> lookUp = new HashSet<>();
        // for(int num : nums){
        //     if (lookUp.contains(num)){
        //         return true;
        //     } else lookUp.add(num);
        // }
        // return false;

        return Arrays.stream(nums).distinct().count()<nums.length;
        
    }
}