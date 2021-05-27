/*
Desc : Here we use two stacks where one is used to store the numbers while another for the baby following the number.
everytime a closing bracket is encountered the current string is multiplied to the number of times of the associated number hashed in the 
number stack.
Time Complexity : O(n)
Space Complexity : O(n)
*/

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length()==0) return s;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0; StringBuilder currStr = new StringBuilder();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num *10+c-'0';
            }else if(c=='['){
                numStack.add(num);
                strStack.add(currStr);
                num = 0;
                currStr = new StringBuilder();
            }else if(c==']'){
                int time = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k=0;k<time;k++){
                    newStr = newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            }else{
                currStr = currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
