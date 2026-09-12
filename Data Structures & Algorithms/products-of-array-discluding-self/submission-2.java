class Solution {
    public int[] productExceptSelf(int[] nums) {

        int leftPro = 1;
        int rightPro = 1;

        int[] result = new int[nums.length];
        
        Arrays.fill(result, 1);  

        for(int i=1; i<nums.length;i++){
            leftPro = leftPro*nums[i-1];
            result[i] = leftPro;
        } 
        for(int j=nums.length-2; j>=0;j--){
            rightPro = rightPro*nums[j+1];
            result[j] = result[j]*rightPro;
        } 
        return result;
    }
}  
