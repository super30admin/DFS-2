//Using Stack

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        int num = 0;
        StringBuilder curString = new StringBuilder();
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(curString);
                //reset
                num = 0;
                curString = new StringBuilder();
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newString.append(curString);
                }
                curString = strStack.pop().append(newString);
            }
            else{
                curString.append(c);
            }
        }
        return curString.toString();
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)