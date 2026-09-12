class Solution {
    public int trap(int[] height) {
        int n = height.length-1;
        int l = 0;
        int r = n;
        int lmax = height[0];
        int rmax = height[n];
        int res = 0;

        while(l<r){
            if (lmax<rmax){
                l++;
                lmax = Math.max(lmax,height[l]);
                res+= lmax-height[l];

            }else{
                r--;
                rmax= Math.max(height[r],rmax);
                res+= rmax-height[r];
            }

        }
        return res;

    }
}
