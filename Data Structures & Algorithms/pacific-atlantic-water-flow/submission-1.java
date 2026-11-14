//pacific 
//atlantic
// from pacific height equal or lower --> pacific 
// if pacific.neighbour contains in atlantic add to result. 
// from atlantic height equal or lower --> atlantic 

//result  

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        ArrayDeque<int[]> pacQ = new ArrayDeque<>(); 
        ArrayDeque<int[]> atlQ = new ArrayDeque<>(); 

                for (int c = 0; c < COLS; c++) {
                    pacQ.add(new int[]{0,c});
                    atlQ.add(new int[]{ROWS-1,c});
                }

                for (int r = 0; r < ROWS; r++) {
                    pacQ.add(new int[]{r,0});
                    atlQ.add(new int[]{r,COLS-1});
                }

                bfs(heights, pacQ, pac );
                bfs(heights, atlQ,atl);


                for (int r  = 0; r  < ROWS; r++) {
                    for (int c = 0; c < COLS; c++) {
                   if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r,c));
                   } 
                    }
                    }
            return result;
        
    }

    public void bfs(int[][]grid,ArrayDeque<int[]> q, boolean[][]ocean){
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][]directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.remove();
            ocean[curr[0]][curr[1]] = true;
            int val = grid[curr[0]][curr[1]];
            for(int[] dir : directions){
                int d_r = curr[0] + dir[0];
                 int d_c = curr[1] + dir[1];

                 if(d_r>=0 && d_c >=0 && d_r<ROWS && d_c <COLS &&  !ocean[d_r][d_c] && grid[d_r][d_c]>= val){
                    q.add(new int[]{d_r,d_c});
                 }
            }
           

        }
    }
}
