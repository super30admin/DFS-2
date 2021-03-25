// Time Complexity : O(k. n), n = length of string s, k = max length of number
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<String> strSt = new Stack<>();

        String currString = "";
        Integer num = 0;
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                num = (num * 10) + (currChar - '0');
    
            }else if(Character.isLetter(currChar)){
                currString =  currString + currChar;
            }    
            else if(currChar == '['){
                numSt.add(num);
                strSt.add(currString);
                currString = "";
                num = 0;
            }else if(currChar == ']'){
                int n = numSt.pop();
                String ss = "";

                for(int k = 0; k < n; k++){
                    ss += currString;
                }
                currString = strSt.pop() + ss;
            }
        }
        return currString;
    }
}
