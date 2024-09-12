// Time complexity - O(length of decoded string)
// Space complexity - O(length of given string)

// DFS on nested strings

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for(int i = 0 ; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num =  num*10 + c - '0';
                // num = Character.getNumericValue(c);
            }else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }else if(c == ']'){
                int t = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k = 0 ; k < t; k++){
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
