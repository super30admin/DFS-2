package com.ds.rani.dfs;

import java.util.Stack;

/**
 *Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

//Approach: Using 2 stacks to  to store the number and to store the string
//Time complexity:o(n) where n is string length
//space complexity: o(1)
public class DecodeString {

    /**
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> numStack=new Stack<Integer>();
        Stack<String> strStack=new Stack<>();
        String result="";
        int i=0;
        //3[a]2[bc]
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int count=0;
                while(Character.isDigit(s.charAt(i))){
                    count=count*10+s.charAt(i)-'0';
                    i++;
                }
                numStack.push(count);//3
            }
            else if(s.charAt(i)=='['){
                strStack.push(result);
                System.out.println(strStack.peek());
                result="";
                i++;
            }
            //when [ bracket occurs then pop the number from numstack and  the string from the strStack
            //append the result n number of times to the value which is poped from the string stack and push final result into stack
            else if(s.charAt(i)==']'){
                int count=numStack.pop();
                String existingstr=strStack.pop();
                for(int j=0;j<count;j++){
                    existingstr+=result;
                }
                result=existingstr;
                System.out.println(result);
                i++;
            }
            else{
                result+=s.charAt(i);
                i++;

            }

        }

        return result;
    }
}
