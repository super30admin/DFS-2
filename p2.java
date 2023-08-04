// Time Complexity : O(n * l) where n is the multiplication of all the numbers in the string and l is the average length of the string
// Space Complexity : O(n * l) where n is the multiplication of all the numbers in the string and l is the average length of the string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Had to lookup character.isdigit function and how to convert string builder to string


// Your code here along with comments explaining your approach
//DFS

class Solution {
    //Global pointer to keep track of which index we are on in the string
    int i;
    public String decodeString(String s) {
        //Using stirng builder as we have to append to the string again and again
        StringBuilder st = new StringBuilder();
        //num used for keeping trach of number in string
        int num = 0;
        //Keep running the loop till we reach the end of the string
        while(i<s.length()){
            char c = s.charAt(i);
            //If character is a digit, save it in num
            if(Character.isDigit(c)){
                i++;
                num = num*10 + (c - '0');

            }
            //If character is opening bracket, recusively get the string which will be the output of the bracket that we founf till the closing jacket
            //Multiply it to the times of num and append it  to result
             else if(c == '['){
                i++;
                String baby = decodeString(s);
                for(int j=0; j< num; j++){
                    st.append(baby);
                }
                num = 0;
            }
            //If we find closing bracket, return the output string
             else if(c == ']'){
                i++;
                return st.toString();
            } 
            //If we find an alphabet, append it to result
            else{
                st.append(c);
                i++;
            }
        }

        return st.toString();
    }
}