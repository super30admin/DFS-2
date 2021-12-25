// Leetcode 394 - Decode String 
// solved on Leetcode
// Time Complexity - O(n*Max(k))
// Space Complexity - O(m+n+k)

class Solution {
    public String decodeString(String s) {
        String currentString = "";
        int currentNumber = 0;
        
        Stack<String> stringStack = new Stack();
        Stack<Integer> integerStack = new Stack();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                currentNumber = currentNumber*10+(ch-'0');
                
            }else if(ch == '['){
                stringStack.push(currentString);
                integerStack.push(currentNumber);
                currentString = "";
                currentNumber = 0;
            }else if(ch == ']'){
                int popped = integerStack.pop();
                String temp = "";
                
                for(int j=0;j<popped;j++){
                    temp =temp+currentString;
                }
                currentString = stringStack.pop() + temp;
            }else {
                currentString+=ch;
            }
        }
        return currentString;
    }
}