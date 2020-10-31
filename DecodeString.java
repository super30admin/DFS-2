//TC: O(n*k)
//SC: O(n)
class Solution {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        if(s == null || s.length() == 0) return currStr.toString();
        
        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0; currStr = new StringBuilder();
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k = 0; k < times; k++){
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            }
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}


//TC: O(n*k)
//SC: O(n)
class Solution {
    int i = 0;
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        if(s == null || s.length() == 0) return currStr.toString();
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                i++;
                num = num*10 + c - '0';
            }
            else if(c == '['){
                i++;
                String inner = decodeString(s);
                for(int k = 0; k < num; k++){
                    currStr.append(inner);
                }
                num = 0;
            }
            else if(c == ']'){
                i++;
                return currStr.toString();
            }
            else{
                i++;
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
