class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if (grid[i][j]=='1'){
                    dfs(new int[]{i,j}, grid);
                    result++;
                }
            }
        }

        return result;
        
    }

        public void dfs(int[] node, char[][]grid){

            if(node[0]>=grid.length || node[1]>=grid[0].length || node[0]<0 ||  node[1]<0 ){
                return;
            }

            if(grid[node[0]][node[1]] == '0') return;

            grid[node[0]][node[1]] = '0';
            dfs(new int[]{node[0]+0, node[1]+1}, grid);
            dfs(new int[]{node[0]+0, node[1]-1}, grid);
            dfs(new int[]{node[0]+1, node[1]+0}, grid);
            dfs(new int[]{node[0]-1, node[1]+0}, grid);
        }



    public void bfs(int[] node, char[][]grid){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int len = grid.length;
        int brth = grid[0].length;


        int[][] neighbours = new int[][]{{-1,0}, {0,1},{1,0},{0,-1}};
        q.add(node);
        grid[node[0]][node[1]] = '0';
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
