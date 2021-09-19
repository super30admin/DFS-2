// Time Complexity : O(k * length of s)
// Space Complexity : O(# nestings)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Iterative soln:
class Solution {
    public String decodeString(String s) {
        if(s== null || s.length() == 0) return "";
        StringBuilder curr = new StringBuilder();
        int num = 0;
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
            }else if(c == '['){ //push inside stacks
                str.push(curr);
                numStack.push(num);
                // reset curr string
                curr = new StringBuilder();
                num = 0;
            }else if(c == ']'){
                // decode
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k=0; k<times; k++){
                    newStr.append(curr);
                }
                //append to parent string
                curr = str.pop().append(newStr);
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
// **********************************
// Time Complexity : O(k * length of s)
// Space Complexity : O(# nestings)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Recursion:
class Solution {
    int i;
    //     i
    // ab2[c3[d]] -> //2 ab //baby 3 c // baby baby 0 d
    public String decodeString(String s) {
        if(s== null || s.length() == 0) return "";
        StringBuilder curr = new StringBuilder();
        int num = 0;
        while( i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
                i++;
            } else if(c == '['){ //call recursion on baby, decode rest of the string
                i++;
                String decoded = decodeString(s);
                // repeat this decoded string times & concat with parent
                StringBuilder newStr = new StringBuilder();
                for(int k=0; k<num; k++){
                    newStr.append(decoded);
                }
                // append to parent
                curr.append(newStr);
                // st.pop() -> parent comes out
                num = 0;
            } else if(c == ']'){
                // decode
                i++;
                return curr.toString();
            } else{
                curr.append(c);
                i++;
            }
        }
        return curr.toString();
    }
}