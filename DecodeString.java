// Time Complexity : The time complexity is O(m*n) where m is the number of repeatitions and n is the maximum length of substring
// Space Complexity : The space complexity is O(h) where h is number of nested strings.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {

        String res = "";

        Stack<String> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();

        int len = s.length();
        int i=0;

        while(i < len){

            // If it is a number push it in the integer stack
            if(Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = count*10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                intStack.push(count);
                continue;
            }
            // If it is '[' push the substring in the string stack
            else if(s.charAt(i) == '['){
                charStack.push(res);
                res = "";
            }
            // If it is ']' creater the substring by popping from the stack
            else if(s.charAt(i) == ']'){
                int count = intStack.pop();
                StringBuilder temp = new StringBuilder(charStack.pop());
                while(count != 0){
                    temp.append(res);
                    count--;
                }
                res = temp.toString();
            }
            // append if its a character
            else{
                res += s.charAt(i);
            }
            i++;

        }

        return res;
    }
}