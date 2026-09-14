class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // return all triplets --> multiple
        // don't return duplicate triplets

        int target = 0;
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();


        for(int i =0; i<nums.length-2;i++){
            
            if ( i>0 && nums[i] == nums[i-1]) continue; ;

            results.addAll(twoSum(nums, target-nums[i], i+1, nums.length-1));
        
        }

        return results;
        
    }

    public List<List<Integer>> twoSum (int[] nums, int target, int l, int r){
        List<List<Integer>> res = new ArrayList<>();
        while (l<r){
            int sum = nums[l]+nums[r];
            if(sum == target){
                 res.add(Arrays.asList(-1 * target,nums[l], nums[r]));
                 l++;
                 r--;
                while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                 
                 }
            if(sum>target) r--;
            if(sum<target) l++;
        }

        return res;
    }
}
