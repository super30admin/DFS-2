public class DecodeString {
  /**
    Approach - 2: Recursive
    
    Time Complexity: O(Math.max(integers in the input String))
    
    Space Complexity: O(Maximum number of nested braces)

    Were you able to solve this on leetcode? Yes
    
    */
    int idx;
    public String decodeString(String s){
        StringBuilder curr = new StringBuilder();
        int num = 0;
        
        while(idx < s.length()){
            char c = s.charAt(idx);
            
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                idx++;
            } else if (c == '[') {
                idx++;
                String decoded = decodeString(s);
                
                for(int l = 0; l < num; l++){
                    curr.append(decoded);
                }
                
                num = 0;
            } else if (c == ']') {
                idx++;
                return curr.toString();
                
            } else {
                curr.append(c);
                idx++;
            }
        }
        
        return curr.toString();
    }
    
    
    /**
    Approach - 1 : Iterative
    
    Time  Complexity : O(Math.max(integers in the input String))
    
    Space Complexity : O(Maximum number of nested braces)
    */
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                
            } else if (c == '['){
                numStack.push(num);
                strStack.push(curr);
                
                // reset the num and currString
                num = 0;
                curr = new StringBuilder();
                
            } else if (c == ']'){
                int k = numStack.pop();
                
                StringBuilder temp = new StringBuilder();
                
                // repeat curr string k times
                for(int j = 1; j <= k; j++){
                    temp.append(curr);
                }
                
                curr = strStack.pop().append(temp);
                
            } else { // character is a letter
                curr.append(c);
            }
        }
        
        return curr.toString();
    }
}
