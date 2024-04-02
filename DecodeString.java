import java.util.Stack;
//tc = o(s) 
//sc = o(currStr) ie result
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            else if(c == '['){
                numSt.push(num);
                strSt.push(currStr);
                currStr = new StringBuilder();
                num = 0;

            }
            else if(c == ']'){
                int popVal = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int k = 0;k<popVal;k++){
                    temp.append(currStr);
                }
                StringBuilder popStr = strSt.pop();
                currStr = popStr.append(temp);
            }
            else{
                currStr.append(c);
            }
        }
        return currStr.toString(); 
    }
}