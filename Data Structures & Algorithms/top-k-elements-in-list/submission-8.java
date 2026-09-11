class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> lookUp = new HashMap<>();
        for(int num : nums) lookUp.put(num,lookUp.getOrDefault(num,0)+1);

        List<Integer>[] buckets = new List[nums.length+1];

        for(int key : lookUp.keySet()){
            int freq = lookUp.get(key);
            if(buckets[freq] == null) {buckets[freq] = new ArrayList<>();}
            {
                buckets[freq].add(key);
            }
        } 

        List<Integer> result = new ArrayList();

        for(int i = nums.length; i>=0; i--){

            if(result.size()>=k){
                break;
            }
            if (buckets[i]!= null){
            result.addAll(buckets[i]);
            }

        }

        int[] res = new int[k];
for (int i = 0; i < k; i++) {
    res[i] = result.get(i);
}
return res; 
        
    }
}
