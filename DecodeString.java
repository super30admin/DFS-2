/*

    Time complexity : O(N*K) N  is the length and K is the no of times string might be repeated in output
    Spacecomplexity : O(N*K)
    is worked on leetcode : YES
*/

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        
        Integer curr_num = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder curr_str = new StringBuilder();
        Stack<Integer> num_st = new Stack();
        Stack<StringBuilder> str_st = new Stack();
        for(int i =0 ;i < s.length();i++){
            Character c = s.charAt(i);
            // case 1 Integer
            
            if(Character.isDigit(c)){
                curr_num = curr_num * 10 + c - '0';
            }
            
            
            // case 2 open bracket
            else if(c == '['){
                num_st.push(curr_num);
                str_st.push(curr_str);
                curr_num = 0;
                curr_str =  new StringBuilder();
            }
            
            
            // case 3 close bracket
            else if(c == ']'){
                Integer num = num_st.pop();
                StringBuilder new_str = new StringBuilder();
                for(int  k =0;k < num; k++){
                    new_str.append(curr_str);
                }
                curr_str = str_st.pop().append(new_str); 
            }
            // case 4 charchter
            else{
                curr_str.append(c);
            }
        }
        return curr_str.toString();
    }
}