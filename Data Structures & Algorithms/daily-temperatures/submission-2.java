class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] result = new int[temps.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i =0; i< temps.length; i++){
            while(!stack.isEmpty()&&stack.peek()[0]<temps[i]){
                int[] curr = stack.pop();
                result[curr[1]] = i-curr[1];
            }
            stack.addFirst(new int[]{temps[i],i});
        }
        // while(!stack.isEmpty()){
        //     int [] curr = stack.pop();
        //     result[curr[1]] =  curr[0];
        // }
        return result; 
    }
}
