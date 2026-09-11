class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        int lookup;
        for(int i =0; i<nums.length; i++){ 
            lookup = target-nums[i];
            if (!set.containsKey(lookup)){
                set.put(nums[i],i);
            }else {
                return new int[]{set.get(lookup), i};
            }
            }
            return new int[]{};
        
    }
}
