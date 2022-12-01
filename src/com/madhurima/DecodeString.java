// Time Complexity : O(n) i.e. length of output string
// Space Complexity : O(level of nesting)
// Did this code successfully run on Leetcode : yes

package com.madhurima;

import java.util.Stack;

public class DecodeString {
}

class SolutionDecodeStringDFS{
    int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        int num = 0;
        StringBuilder curr = new StringBuilder();

        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                i++;
                num = num*10 + (c - '0');
            }else if(c == '['){
                i++;
                String decoded = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < num; j++){
                    newStr.append(decoded);
                }
                curr.append(newStr);
                num = 0;
            }else if(c == ']'){
                i++;
                return curr.toString();
            }else{
                i++;
                curr.append(c);
            }
        }

        return curr.toString();
    }
}

class SolutionDecodeStringBFS{
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int num = 0;
        StringBuilder curr = new StringBuilder(); //as it appends without creating new strings

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
            }else if(c == '['){
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            }else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newStr.append(curr);
                }
                curr = strStack.pop().append(newStr);
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
