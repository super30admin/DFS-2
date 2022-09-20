//TC: O(m*n) where m is the number of rows, n is the number of columns
//SC: O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 2 - Recursion
//TC: O(n) where n is the length of output string
//SC: O(b) where b is the number of opening brackets in the input string
class Solution {
    int i;
    public String decodeString(String s) {

        StringBuilder currStr = new StringBuilder();
        int num =0;

        while(i < s.length()){
            char c = s.charAt(i);
            //if the character is a digit
            if(Character.isDigit(c)){
                num = num *  10 + c - '0';
                i++;
            }
            //if the character is '['
            else if(c == '['){
                i++;
                String decoded = decodeString(s);
                for(int j = 0 ; j < num ; j++){
                    currStr.append(decoded);
                }
                num = 0;
            }
            //if the character is ']'
            else if(c == ']'){
                i++;
                return currStr.toString();
            }
            //if the character is a character
            else{
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}
//Method 1 - DFS
//TC: O(n) where n is the length of output string
//SC: O(b) where b is the number of opening brackets in the input string
class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int num =0;

        for(int i = 0 ; i< s.length() ; i++){
            char c = s.charAt(i);
            //if the character is a digit
            if(Character.isDigit(c)){
                num = num *  10 + c - '0';
            }
            //if the character is '['
            else if(c == '['){
                strSt.push(currStr);
                numSt.push(num);

                //reset values
                currStr = new StringBuilder();
                num = 0;
            }
            //if the character is ']'
            else if(c == ']'){
                int k = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0 ; j < k ; j++){
                    temp.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            }
            //if the character is a character
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}