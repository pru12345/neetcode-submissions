class Solution {
    public int maxArea(int[] heights) {
        int vol = 0;
        int l = 0, r= heights.length-1;
        
        while(l<r){
            vol = Math.max(vol,Math.abs(Math.min(heights[l],heights[r])) * (r-l));
            if (heights[l]>heights[r]){
                r--;
            }else l++;
        }
        return vol;
    }
}
