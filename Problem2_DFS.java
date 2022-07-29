//Time Complexity: O(max_number * n); where n is the size of string and max_number is the max times that repetition occurs.
//Space Complexity: O(n * l); where l is the level of nesting.
//Code run successfully on LeetCode.

public class Problem2_DFS {

    public String decodeString(String s) {
        
        if(s == null|| s.length() == 0)
            return " ";
        
        StringBuilder currString = new StringBuilder();
        int num = 0;
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        for(int i =0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            
            else if(c == '['){
                
                numStack.push(num);
                num = 0;
                strStack.push(currString);
                currString = new StringBuilder();
            }
            
            else if(c == ']'){
                
                int times = numStack.pop();
                
                StringBuilder newString = new StringBuilder();
                
                for(int j =0; j < times; j++){
                    
                    newString.append(currString);
                }
                
                currString = strStack.pop().append(newString);
            }
            
            else
                currString.append(c);
        }
         return currString.toString();
    }
}
