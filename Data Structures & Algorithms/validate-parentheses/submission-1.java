class Solution {
    public boolean isValid(String s) {  
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> closeToOpen = Map.of('(', ')', '[', ']', '{', '}');
    for(char ch : s.toCharArray()){
        if(closeToOpen.containsKey(ch)){
            stack.push(closeToOpen.get(ch)); //opposite
            continue; 
        }
        if(stack.isEmpty() || stack.pop() != ch) return false;
    }

    return stack.isEmpty();

        
    }
}
