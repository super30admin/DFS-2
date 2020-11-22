// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : When repeatNum > 10, solution fails

class Solution {
    public String decodeString(String s) {
        String result = "";
        String currentString = "";
        int currentNum = 0;
        Stack<String> strings = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char currentChar= s.charAt(i);
            if(Character.isDigit(currentChar)) {
                currentNum +=  (currentNum * 10) + (currentChar - '0');
            }
            else if(currentChar == '['){
                strings.push(currentString);
                currentString = "";
                nums.push(currentNum);
                currentNum = 0;
            }
            else if(currentChar == ']'){
                String newString = strings.pop();
                int repeatNum = nums.pop();
                for(int j = 0; j < repeatNum; j++){
                    newString += currentString;
                }
                currentString = newString;
            }
            else{
                currentString += currentChar;
            }
        }
        
        return currentString;
    }
}