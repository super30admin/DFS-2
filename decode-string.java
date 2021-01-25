decode-string

Time:O(n*k)
Space:O(n)


class Solution {
    public String decodeString(String s) {  
        
        if(s==null || s.length()==0) return s;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        StringBuilder currStr = new StringBuilder();
        
        int num = 0;
        
        for(int i=0;i<s.length();i++){
            
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+c - '0';
                
            } else if(c =='['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0; currStr = new StringBuilder();
            } else if(c ==']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k=0;k<times;k++){
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            } else {
                currStr.append(c);
            }
            
        }
        return currStr.toString();
    }
}
