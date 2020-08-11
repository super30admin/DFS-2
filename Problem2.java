// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.Stack;
import java.util.Collections;

// Your code here along with comments explaining your approach
// Approach 1: Using Stack
// Time Complexity : O(n * max(k))
//      n: length of the String
//      k: Multiplication factor
// Space Complexity : O(n)
//      n: length of the String
class Problem2S1 {

    /** Decode the string */
    public String decodeString(String s) {
        
        // edge case
        if(s==null || s.length() ==0)
            return s;
        
        // Using string builder as we need to append many times
        StringBuilder current = new StringBuilder();
        StringBuilder number = new StringBuilder();
        
        // Stack
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        // iterate all the characters
        for(int i=0; i<s.length();i++){
            
            char c = s.charAt(i);

            // closing bracket then pop
            if(c == ']'){

                // first mutiply the current string by k factor(popped from numsStack)
                String temp = String.join("", Collections.nCopies(numStack.pop(), current)); // gets n copies
                
                // Pop from String stack and append decoded part 
                current = stringStack.pop().append(temp);
            }
            // opening bracket then push
            else if(c == '['){
                stringStack.push(current);
                numStack.push(Integer.parseInt(number.toString()));

                // clear
                current = new StringBuilder();
                number = new StringBuilder();
            // if digit add to number
            }else if(Character.isDigit(c)){
                number.append(c);
            // character
            }else {
                current.append(c);
            }   
        }
        // requires string 
        return current.toString();
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using DFS
// Time Complexity : O(n * max(k))
//      n: length of the String
//      k: Multiplication factor
// Space Complexity : O(n)
//      n: length of the String
//     Stack space
class Problem2S2 {

    // global index
    int index = 0;

    /** decode the string */
    public String decodeString(String s) {
        
        // edge case
        if(s==null || s.length() ==0)
            return s;
        else
            return depthFirst(s);
    }

    /** DFS */
    private String depthFirst(String s){

        // current string
        StringBuilder current = new StringBuilder();
        // number
        int number = 0;

        // traverse entire string
        while(index<s.length()){
            
            char c = s.charAt(index);

            // pop operation means return -> BASE CASE
            if(c == ']'){
                
                return current.toString();
            }// push means recursive call
            else if(c == '['){
                // next point
                index++;
                // get inner string
                String innerString = depthFirst(s);
                // decode it 
                StringBuilder temp = new StringBuilder();
                while(number != 0){
                    temp.append(innerString);
                    number--;
                }
                // add to current
                current.append(temp);
            // type number
            }else if(Character.isDigit(c)){
                number = number*10 + c - '0';
            }else {
                current.append(c);
               
            } 
            // increase index
            index++;
        }
        // return as String
        return current.toString();
    }
}
