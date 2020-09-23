// Time Complexity : O(n) n = length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        
        if(s == null || s.length() == 0)    return "";
        
        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();
        int num = 0;
        
        StringBuilder sb = new StringBuilder();
        StringBuilder sbapp = new StringBuilder();
        
        for(char ch: s.toCharArray()){
            
            if(Character.isDigit(ch)){  //check for digit
                num = num * 10 + ch - '0';
            }else if(ch == '['){    //opening brace
                
                numStack.push(num);
                num = 0;
                strStack.push(sb);
                sb = new StringBuilder();
                
            }else if(ch == ']'){    //closing brace
                
                int n = numStack.pop();
                
                while(n-- > 0){
                    sbapp.append(sb);
                }
                sb = new StringBuilder();
                sb = sb.append(strStack.pop() + sbapp.toString());
                sbapp = new StringBuilder();
                
            }else{  //character
                sb.append(ch+"");
            }
        }
        return sb.toString();
    }
}
