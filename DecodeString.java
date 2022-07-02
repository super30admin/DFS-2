// Time Complexity : O(L) where L is the length of output string
// Space Complexity : O(d) where d is the max depth or number of open brackets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class DecodeString {
    public String decodeString(String s) {
        Stack<String> strings = new Stack<String>();
        Stack<Integer> counts = new Stack<Integer>();
        StringBuilder str = new StringBuilder();
        int k=0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                //Checking if number or not
                k = k*10+s.charAt(i)-'0';
            }
            else if(s.charAt(i)=='['){
                //pushing the count and string to respective stacks and initialize number to 0
                counts.push(k);
                strings.push(str.toString());
                str = new StringBuilder();
                k=0;
            }
            else if(s.charAt(i)==']'){
                //Found the innermost string now pop the same multiply it.
                StringBuilder temp = new StringBuilder();
                temp.append(strings.pop());

                int limit = counts.pop();
                for(int j=0;j<limit;j++){
                    temp.append(str);
                }
                str = temp;
            }
            else{
                //If no number before string just append;
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String [] args){
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[bc]"));
    }
}