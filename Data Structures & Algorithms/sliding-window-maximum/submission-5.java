class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1 <= k <= nums.length
        // int[] - outputSize nums.length-k
        //Dupilicates? 
        //not sorted
        // DS -- Mono Decresing queue

        int l =0 , r =0;
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer > q = new ArrayDeque<>();

        while(r<n){
            while(!q.isEmpty()&& (nums[q.getLast()]< nums[r]))
                {
                    q.removeLast();
                }
            q.addLast(r);

            if(l>q.getFirst()){
                q.removeFirst(); // edgeCase
            }

            if((r+1)>=k){
                result[l] = nums[q.getFirst()];
                l++;
            }

            r++;
            
        }
        return result;
        // for(int i =0; i<k-1;i++){
        //     if(d.isEmpty()) d.add(nums[i]);
        //     else if(g.getFirst()>nums[i]){
        //         //pop every thing 
        //         //add at end
        //     }
        //     else{
        //         //pop from back and 
        //         //add at the end
        //     } 
        // } 

        // int max = d.getFirst();

        // for(int r =k; r < nums.length-1;r++){
            
            

        //     l++;
        // }



    }
}
