/*

Approach: we can solve either using recursion/DFS or own stacks
once innermost child is processed then we have to combine the result 
with the parent

Here 
    [ --> means that we have to process the child,
    ] --> means that we have processed the child already,

using two stack approach we have to maintain alphabets and numbers.

*/

// Time: kxn
// Space: kxn --> stringbuilder is also account into space complexity.

// Yes the code successfully ran over leetcode



class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>(); // number stack
        Stack<StringBuilder> strSt= new Stack<>(); // string stack

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }else if(c == '['){
                strSt.push(currStr); // push string to string stack
                numSt.push(currNum); // push number to num stack

                // reset the variables to form the baby
                currNum = 0;
                currStr = new StringBuilder();

            }else if(c == ']'){
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int k=0; k<count; k++){
                    child.append(currStr); // append the generated subresult
                }
                StringBuilder parent = strSt.pop();
                parent.append(child);
                currStr = parent;

            }else{
                currStr.append(c);
            }
        } 
        return currStr.toString();
    }
}