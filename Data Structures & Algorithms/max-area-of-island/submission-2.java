class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows ; i++){
             for(int j = 0; j < cols ; j++){
                if (grid[i][j]==1) maxArea = Math.max(maxArea, bfs(grid,new int[]{i,j}));
             }
        }
        return maxArea;
        
    }

    public int bfs(int[][] grid, int[] start){

        int rows = grid.length;
        int cols = grid[0].length;
        int area = 0;

        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        grid[start[0]][start[1]] = 0;
        area++;

        while(!queue.isEmpty()){
            int[] curr = queue.remove();
            for(int[] dir : directions){
                int r = curr[0];
                int c = curr[1];
                if(r+dir[0]>=0 && c+dir[1]>= 0 && r+dir[0]<rows && c+dir[1]<cols && grid[r+dir[0]][c+dir[1]] == 1){
                    queue.add(new int[]{r+dir[0],c+dir[1]});
                    grid[r+dir[0]][c+dir[1]] = 0;
                    area++;
                }
            }
        }

        return area;


    }
}
