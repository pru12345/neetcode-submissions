class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, HashSet<Integer>> lookup = new HashMap<>();
        for(int i =0; i< board.length;i++){
                for(int j =0; j< board[0].length;j++){
                    char cur_ch = board[i][j];

                    if ( cur_ch!= '.'){

                        int cur = (int) cur_ch;

                        if(lookup.get("R"+i)==null){
                            lookup.put("R"+i, new HashSet<>());
                            }
                        if(lookup.get("R"+i).contains(cur)) return false;
                        else lookup.get("R"+i).add(cur);

                        if(lookup.get("C"+j)==null){
                            lookup.put("C"+j, new HashSet<>());
                            }
                        if(lookup.get("C"+j).contains(cur)) return false;
                        else lookup.get("C"+j).add(cur);

                        int m1 = i/3;
                        int m2 = j/3;

                        if(lookup.get("M"+m1+m2)==null){
                            lookup.put("M"+m1+m2, new HashSet<>());
                        }
                        if(lookup.get("M"+m1+m2).contains(cur)) return false;
                        else lookup.get("M"+m1+m2).add(cur);


                    }



                }
        }

        return true;
        
    }
}
