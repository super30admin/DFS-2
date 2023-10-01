class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;


        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c-'0';// '5' - '0' --> gives 5
            } else if(c == '['){
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;

            } else if ( c== ']'){
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int k=0; k<count; k++){
                    child.append(currStr);
                }
                StringBuilder parent = strSt.pop();
               currStr= parent.append(child);

            } else {
                //alphabet
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}







/*

TC : O(n)
Sc : O(n)

Description : 

This is a DFS problem, Because we need to go into depth first. 

By iterating through the whole String, first storing all the numbers that we got in one variable  and numbers that we got in another variable.

When we find any ‘[‘ Open bracket, starting recursion. Pushing parent into the stack and going to baby  → Pushing numbers that we got into numbers stack and strings that we got into strings stack.



 */