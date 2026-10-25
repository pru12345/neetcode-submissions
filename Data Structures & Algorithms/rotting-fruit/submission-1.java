class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int good = 0;
        int[] result = new int[]{};
        ArrayList<int[]> source = new ArrayList<>();

        for(int i =0; i< ROWS; i++){
             for(int j =0; j< COLS; j++){

                if(grid[i][j]==1) ++good;
                if(grid[i][j]==2) source.add(new int[]{i, j});

             }

        }

        if(good== 0) return 0;

        result = bfs(grid, good, source); // time, good

        if(result[1]>0) return -1;

        return result[0];
    }


    public int[] bfs(int [][] grid, int good, ArrayList<int[]> source){
        int ROWS = grid.length;
        int COLS = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addAll(source);
        int[][] dirs = new int[][] {{1, 0}, {-1, 0},{0, 1}, {0, -1}};
        int min = 0;
        while(!q.isEmpty()){
            int size = q.size();     
            boolean rotted = false; 
            for (int i = 0; i < size; i++) { 
            int[] curr = q.remove();   
            for(int[] dir : dirs){
                int r = curr[0]+ dir[0]; 
                int l = curr[1]+ dir[1];
                if(l>=0 && r>=0 && l<COLS && r<ROWS && grid[r][l] == 1){
                q.add(new int[]{r,l});
                --good;
                grid[r][l] = 2;
                rotted = true;

                    }
                }
            }
    if (rotted) {
        ++min;
    }
        }
        return new int[]{min,good};
    }
    
    }