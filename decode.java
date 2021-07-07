// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();		// initialize 2 stacks - 1 for integers and 1 for characters
        Stack<String> string = new Stack<>();
        String result = "";		// empty string to append the characters and final result
        int index = 0;			// to traverse through the whole array
        
        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))){ 		// find the integers
                int counts = 0;
                
                while(Character.isDigit(s.charAt(index))){
                    counts = 10 * counts + s.charAt(index) - '0';		// if the integer is more than 1 digit, multiply 10 to move to next position
                    index++;
                }
                count.push(counts);		// push the integer to stack
            }
            
            else if(s.charAt(index) == '['){		// once we find the opening  braces, push the result string to stack
                string.push(result);
                result = "";
                index++;
            }
            
            else if(s.charAt(index) == ']'){		// once we find the closing braces, pop the result from string stack and integer stack multiply the result
                String temp = string.pop();
                int counts = count.pop();
                for(int i = 0; i < counts; i++){
                    temp += result;
                }
                result = temp;
                index++;
            }
            
            else{
                result += s.charAt(index);			// if none of the above cases are met, we know it's character, append to the result.
                index++;
            }
        }
        return result;
    }
}