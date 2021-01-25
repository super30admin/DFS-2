class Solution {
    public String decodeString(String s) {
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                //d // times 3
                for(int k = 0;k<times;k++){
                    newStr.append(currStr);
                } //newStr = ddd
                // combine it with parent
                currStr = strStack.pop().append(newStr);
            }
            else{
                // c is a letter
                currStr.append(c);
            }
        }
        return currStr.toString();
        
        
    }
}
