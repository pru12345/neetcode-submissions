class Solution {
    public int evalRPN(String[] tokens) {   
        Set<String> set = Set.of("+","-","*","/");
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if(set.contains(token)){
                int s = stack.pop();
                int f = stack.pop();
                int res = 0;
                    if(token.equals("+")) res = f +s ;
                    if(token.equals("-")) res = f -s ;
                    if(token.equals("*")) res = f *s ;
                    if(token.equals("/")) res = f /s ;
                stack.addFirst(res);
            }else{
                stack.addFirst(Integer.parseInt(token));
            }
        }

        return stack.pop();
        
    }
}
