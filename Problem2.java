// Time Complexity - O(n) where n is the length of the String
// Space Complexity - O(n) where n is the length of the String. n is the total space used by both the stacks


class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();   // To store integer
        int currNum = 0;
        String currStr = "";
        for(int k =0;k < s.length(); k++){
            char c = s.charAt(k);
            if(Character.isDigit(c)){
                currNum = currNum * 10 +c -'0';
            }
            else if(c == '['){
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";
            }
            else if(c == ']'){
                int num = numStack.pop();
                StringBuilder str = new StringBuilder();
                for(int i=0; i< num;i++){
                    str.append(currStr);   
                }
                currStr = strStack.pop() + str;
                
            }
            else{
                currStr += c; 
            }
        }
        return currStr;
    }
}
