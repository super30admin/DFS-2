// Time Complexity : O(length of stack * longest number)
// Space Complexity : O(length of stack * longest number)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes (Syntax error)


// Your code here along with comments explaining your approach: Using DFS

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            // for Char ']'
            if(s.charAt(i) == ']'){
                List<Character> list = new ArrayList<>();
              
                while(stack.peek() != '['){
                  list.add(stack.pop());  
                }    
                
                stack.pop();
                int base = 1;
                int output = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    output = output + (stack.pop() - '0')*base;
                    base *= 10;
                }
                
                while(output != 0){
                    for(int j = list.size()-1; j >= 0 ; j--){
                        stack.push(list.get(j));
                    }
                    output--;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        
        char[]  result = new char[stack.size()];
        for(int i = result.length-1 ; i >= 0; i--){
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
