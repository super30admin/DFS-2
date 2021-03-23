class Solution {
    int i =0;
    public String decodeString(String s) {
        
        if(s == null || s.length() == 0)
            return s;
        int currNum = 0;
        String currStr = "";
        Stack<Integer> numStack = new Stack<>();
        Stack <String> strStack = new Stack<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                currNum =currNum*10 + c- '0';
                
            }
            else if( c == '['){
                numStack.push(currNum);
                strStack.push(currStr);
                currNum =0;
                currStr = "";
            }
            else if (c == ']'){
                int times = numStack.pop();
            StringBuilder newString = new StringBuilder();
            for(int k =0; k<times ; k++){
                newString.append(currStr);
                
            }
                currStr = strStack.pop() + newString;
            }
            else{
                currStr += c;
            }
        }
        
        return currStr;
        
    }
}