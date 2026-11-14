//   [2147483647,      -1,         0,  1],
//   [2147483647,2, 1,    -1],
//   [1,      -1,  2,    -1],
//   [0,      -1,  2147483647, 2147483647]

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int inf = 2147483647;
        int chest = 0;
        int water = -1;

        int row = grid.length; 
        int col = grid[0].length;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int i =0; i< row; i++){
            for(int j =0; j< col; j++){
                 if(grid[i][j]== chest) q.add(new int[]{i,j});
        }
        }
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.remove();
            for(int[] dir : directions){
                int d_row = dir[0] + curr[0];
                int d_col = dir[1] + curr[1];

                if(d_row>=0 && d_col>=0 && d_row<row && d_col<col && grid[d_row][d_col]==inf){
                     grid[d_row][d_col] =  grid[curr[0]][curr[1]]+1;
                     q.add(new int[]{d_row, d_col});
                }

            }
        }

    }

}