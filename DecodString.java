//Time Complexity: O(n2) where n is the length of the string
//Space Complexity: O(n) for elements of the string 

import java.util.*;

public class DecodString {
    public String decodeString(String s) {
        char ca[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            // Push elements to stack if its not open brace
            if(ca[i] != ']') 
                stack.push(ca[i]);
            else{
                // If closing brace do following operation:
                // 1. popping elements from stack until the opening brace is encountered
                StringBuilder sb = new StringBuilder("");
                while(stack.peek()!='[') 
                    sb.insert(0,stack.pop());
                stack.pop();
                int digit=0,place=1;
                while(stack.size()>0 && Character.isDigit(stack.peek())){ 
                    //this is for the case where digit length is >1 like 10,11,44,etc
                    int d = Integer.valueOf(String.valueOf(stack.pop()));
                    digit += d*place;
                    place *= 10;
                }
                String repeated = sb.toString().repeat(digit);
                for(char ch : repeated.toCharArray()) 
                    stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(stack.size()>0) ans.insert(0,stack.pop());
        return ans.toString();
    }
}