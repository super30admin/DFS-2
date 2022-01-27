// Time Complexity : O(km) where m is length of input string and k is max number in the encoded string
// Space Complexity : O(c + n) where c is number of characters in the input string and n is number of number in the input string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

import java.util.*;
public class DecodeString {
    
}

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        Stack<Integer> numSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                //number
                //keep on collecting number. number can be nultiple digit
                num = num * 10 + c - '0';
                
            }else if(c == '['){
            //[
                //time to add collected number and string in the stack
                strSt.push(sb.toString());
                numSt.push(num);
                num = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
            //]
            //decrypt the subset of string when ] is encounered
                int k = numSt.pop();
                StringBuilder temp = new StringBuilder();
                temp.append(strSt.pop());
                for(int j=0; j<k; j++){ // runs k times
                    temp.append(sb.toString());
                }
                sb = temp;
            }else{
            //string
            //keep on collecting characters
                sb.append(c);
            }
        }
        return sb.toString();
    }
}