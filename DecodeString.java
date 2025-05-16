import java.util.Stack;

//Time Complexity: O(n)
// Space Complexity: O(n)
// Approach: BFS

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        int num =0; String currStr = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }else if(c == '['){
                numStack.push(num);
                stringStack.push(currStr);
                num = 0;
                currStr = "";
            }else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0;j<times;j++){
                    newStr.append(currStr);
                }
                currStr = stringStack.pop();
                currStr += newStr;
            }else{
                currStr += c;
            }
        }
        return currStr;
    }
}