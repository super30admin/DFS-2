import java.util.Stack;

// Time Complexity : O(max(n, l)) where n = number of characters in given string, l = maximum number in given string
// Space Complexity : O(n) where n = number of characters in given string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//394. Decode String (Medium) - https://leetcode.com/problems/decode-string/
class Solution {
	
	int index;
	
    public String decodeString(String s) {
    	// Time Complexity : O(max(n, l)) where n = number of characters in given string, l = maximum number in given string
    	// Space Complexity : O(n) where n = number of characters in given string
//        Stack<StringBuilder> strStack = new Stack<>();
//        Stack<Integer> numStack = new Stack<>();
//        StringBuilder currStr = new StringBuilder();
//        int currNum = 0;
//        
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            
//            if (Character.isDigit(ch)) {
//                currNum = currNum * 10 + ch - '0';
//            } else if (ch == '[') {
//                strStack.push(currStr);
//                numStack.push(currNum);
//                currStr = new StringBuilder();
//                currNum = 0;
//            } else if (ch == ']') {
//                int count = numStack.pop();
//                StringBuilder parent = strStack.pop();
//                
//                for (int j = 0; j < count; j++) {
//                    parent.append(currStr);
//                }
//                currStr = parent;
//            } else {
//                currStr.append(ch);
//            }
//        }
//        
//        return currStr.toString();
        
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        
        while (index < s.length()) {
            char ch = s.charAt(index);
            
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
                index++;
            } else if (ch == '[') {
                index++;
                String child = decodeString(s); // st.pop() happens, currStr currNum is mapped
                for (int i = 0; i < currNum; i++) {
                    currStr.append(child);
                }
                currNum = 0;
            } else if (ch == ']') {
                index++;
                return currStr.toString();
            } else {
                currStr.append(ch);
                index++;
            }
        }
        
        return currStr.toString();
    }
}