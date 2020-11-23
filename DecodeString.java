package S30.DFS_2;
/*
Time Complexity : Put: O(kN), k is number of times, N is encoded string
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        if(s == null || s.length() == 0) return "";
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            //4 cases possible
            if(Character.isDigit(ch)){
                num = num*10 + ch - '0';
            }else if(ch == '['){
                numberStack.push(num);
                stringStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }else if(ch == ']'){
                int times = numberStack.pop();
                StringBuilder result = new StringBuilder();
                for(int j = 0; j < times; j++){
                    result.append(currStr);
                }
                currStr = stringStack.pop().append(result);
            }else{
                currStr.append(ch);
            }
        }

        return currStr.toString();

    }

    int i = 0;
    public String decodeStringRecursive(String s) {

        if(s == null || s.length() == 0) return "";
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()){
            char ch = s.charAt(i);
            //4 cases possible
            if(Character.isDigit(ch)){
                num = num*10 + ch - '0';
                i++;
            }else if(ch == '['){
                i++;
                String childString = decodeString(s);
                StringBuilder result = new StringBuilder();
                for(int j = 0; j < num; j++){
                    result.append(childString);
                }
                currStr.append(result);
                num = 0;
            }else if(ch == ']'){
                i++;
                return currStr.toString();
            }else{
                currStr.append(ch);
                i++;
            }
        }

        return currStr.toString();

    }
}
