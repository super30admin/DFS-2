    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/decode-string/
    Time Complexity for operators : o(n) n = length of a string. 
    Extra Space Complexity for operators : o(n) ... used TWO stack's
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : Nos
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
            Iterative approach   
                    A. We used two stacks here, first will be to store integres and second to store string.
                    B. If digits occured, We will cauclate if num > 9 with this formula    currInt = currInt * 10 + (ch - '0');
                    C. if '[' string got this bracket, then we will push integer and the currentstring on to the stack.
                       and nullify them.
                    D. IF ']'occured, then pop int array and repeat number of popped integer times the currentstring into temp.
                    E. pop the string array and add currentstring (popped string) and temp string.
                    F. if non of above 3 conditions met, that means its a character, we willadd it to currentString.
                    G. in the end, return currentString.

       */


class decodeString {
    public String decodeString(String s) {
        if(s==null || s.length() == 0)
            return "";
        
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int currInt = 0;
        String currString = "";

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currInt = currInt * 10 + (ch - '0');
            }else if(ch == '['){
                intStack.push(currInt);
                stringStack.push(currString);
                
                currInt = 0;
                currString = "";
                
            }else if(ch == ']'){
                int popped = intStack.pop();
                String temp = "";
                for(int j=0;j<popped;j++){
                    temp += currString;
                }
                
                currString = stringStack.pop();
                currString = currString + temp;
                
            }else{
                currString += ch;
            }
        }
        
        return currString;   
    }
}