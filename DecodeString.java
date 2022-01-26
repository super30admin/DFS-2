package dfs2;

import java.util.Stack;

public class DecodeString {
	//Iterative
	//Time Complexity : O(n), where n is the length of the deciphered string
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public String decodeString(String s) {
        // null
        if(s == null || s.length() == 0)
            return s;
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currSb = new StringBuilder();
        int currNum = 0;
        
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c))
                currNum = currNum * 10 + (c - '0');
            else if(Character.isLetter(c))
                currSb.append(c);
            else if(c == '[') {
                numStack.push(currNum);
                strStack.push(currSb);
                currSb = new StringBuilder();
                currNum = 0;
            } else {
                int num = numStack.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(strStack.pop());
                for(int i=0; i<num; i++)
                    sb.append(currSb);
                currSb = sb;
            }
        }
        
        return currSb.toString();
    }
	
	//Recursive
	//Time Complexity : O(n), where n is the length of the deciphered string
	//Space Complexity : O(n), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	int i;
    public String decodeString1(String s) {
        // null
        if(s == null || s.length() == 0)
            return s;
        
        StringBuilder currSb = new StringBuilder();
        int currNum = 0;
        
        while(i < s.length()) {
            char c = s.charAt(i); 
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
                i++;
            } else if(Character.isLetter(c)) {
                currSb.append(c);
                i++;
            } else if(c == '[') {
                i++;
                String inner = decodeString(s);
                StringBuilder child = new StringBuilder();
                for(int k=0; k<currNum; k++)
                    child.append(inner);
                currSb = currSb.append(child);
                currNum = 0;
            } else {
                i++;
                return currSb.toString();
            }
        }
        
        return currSb.toString();
    }
}
