class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //HashMap and Queue

        HashMap<Integer, Integer> lookup = new HashMap();

        for(int num : nums){ lookup.put(num, lookup.getOrDefault(num, 0) +1 );}

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int key : lookup.keySet()){
            heap.offer(new int[]{key,lookup.get(key)});
            if(heap.size()>k){
                heap.poll();
            }
            
        
        }

        int[] res= new int[k]; 

        for (int i=0; i<k; i++){
            res[i] = heap.poll()[0];
        }

        return res;
        



        
    }
}
