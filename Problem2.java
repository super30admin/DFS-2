// Time Complexity :O(length of output string)
// Space Complexity : O(length of output string)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Check if character is digit, character or open or close brace. 
 * If character, append to string. 
 * If digit, store it in current number. 
 * If opening brace, increment i and run recursion on rest of string. 
 * Apend the child with the parent and repeat it with child the number of times mentioned in curr Number variable. 
 * If closed brace is encountered, return the string to the parent. 
 */

public class Problem2 {
    int i;
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int currNum = 0; 
        while( i < s.length() ){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c-'0'; 
                i++;
            }
            else if (c == '['){
                i++; 
                String child = decodeString(s);
                for(int k =0; k < currNum; k++){
                    currStr.append(child);
                }
                currNum = 0; 
                i++;
            }
            else if(c == ']'){
                return currStr.toString();
            }
            else {
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}
