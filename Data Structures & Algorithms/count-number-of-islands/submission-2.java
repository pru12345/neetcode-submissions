class Solution {
    public int numIslands(char[][] grid) {
        HashSet<String> visited = new HashSet<>();
        int result = 0;
        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if (grid[i][j]=='1' && !visited.contains(i+"_"+j)){
                    bfs(new int[]{i,j}, grid, visited);
                    result++;
                }
            }
        }

        return result;
        
    }

    public void bfs(int[] node, char[][]grid, HashSet<String> visited){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int len = grid.length;
        int brth = grid[0].length;


        int[][] neighbours = new int[][]{{-1,0}, {0,1},{1,0},{0,-1}};
        q.add(node);
        visited.add(node[0]+ "_" + node[1]);       
        while(!q.isEmpty()){
            int[] curr = q.remove();
            for(int[] ngh : neighbours){

                if(ngh[0]+curr[0]>=0 && ngh[1]+curr[1] >=0 && ngh[0]+curr[0]<len && ngh[1]+curr[1]<brth && grid[ngh[0]+curr[0]][ngh[1]+curr[1]]=='1'&& !visited.contains((ngh[0]+curr[0]) + "_" + (ngh[1]+curr[1]))){
                    q.add(new int[]{ngh[0]+curr[0],ngh[1]+curr[1]});
                    visited.add((ngh[0]+curr[0]) + "_" + (ngh[1]+curr[1]));
                }

            }
        }
    }


}
