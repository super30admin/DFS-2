## Problem2 (https://leetcode.com/problems/decode-string/)

Approach : In this question we are using 2 stacks one to store numbers and other to store the strings also we will be maintaining 2 variables one to store the string and other to store the number
In this the string can have : a-z, [ , ],number
if we get a character we will add it in a string
if we get a number we will add it in a number variable
if we get a [ then we will push both the variables in respective stack and make it 0 and ""
if we get a ] then we will pop the number from the stack multiply the string variable that many times and then pop from the string stack and append it
Time Complexity : O(n)
Space Complexity : O(depth)

class Solution {
    public String decodeString(String s) {
        //Base Condition
        if(s==null || s.length()==0){
            return "";
        }
        //Stack declaration and initialization
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        //Variables declaration
        int num=0;
        StringBuilder st=new StringBuilder();
        //loop through the given string
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+Character.getNumericValue(c);
            }
            else if(c == '['){
                str.push(st);
                nums.push(num);
                st=new StringBuilder();
                num=0;
            }
            else if(c== ']'){
                int times=nums.pop();
                StringBuilder sb =new StringBuilder();
                for(int j=0;j<times;j++){
                    sb.append(st);
                }
                st=str.pop().append(sb);
            }
            else{
                st.append(c);
            }
        }
        return st.toString();
    }
}
