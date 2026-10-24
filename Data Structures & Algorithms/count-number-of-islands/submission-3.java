class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if (grid[i][j]=='1'){
                    bfs(new int[]{i,j}, grid);
                    result++;
                }
            }
        }

        return result;
        
    }

    public void bfs(int[] node, char[][]grid){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int len = grid.length;
        int brth = grid[0].length;


        int[][] neighbours = new int[][]{{-1,0}, {0,1},{1,0},{0,-1}};
        q.add(node);
        while(!q.isEmpty()){
            int[] curr = q.remove();
            for(int[] ngh : neighbours){

                int l = ngh[0]+curr[0];
                int r = ngh[1]+curr[1];

                if(l>=0 &&  r>=0 && ngh[0]+curr[0]<len && r<brth && grid[l][r]=='1'){
                    q.add(new int[]{l,r});
                    grid[l][r] = '0';
                }

            }
        }
    }


}
