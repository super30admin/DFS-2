//Time: O(n * maxK)
//Space: O(m*n)
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            }
            else if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            else{
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }
}
