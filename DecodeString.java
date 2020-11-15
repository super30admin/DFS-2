/**
 * TC : O(N) SC : O(N)
 * Approach : Apply DFS using two stack one for number and other for strings, check conditions for digit and braces.
 */

class Solution {
    public String decodeString(String s) {
        if(s == null) return s;
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> stringSt = new Stack<>();
        StringBuilder tempSt = new StringBuilder();
        int tempNum = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                tempNum = 10*tempNum + c - '0';
            } else if(c == '['){
                stringSt.add(tempSt);
                numSt.add(tempNum);
                tempNum = 0;
                tempSt = new StringBuilder();                
            } else if(c == ']'){
                int rep = numSt.pop();
                StringBuilder repSt = new StringBuilder();
                while(rep > 0){
                    repSt.append(tempSt);
                    rep--;
                }
                tempSt = stringSt.pop().append(repSt);
            } else {
                tempSt.append(c);
            }
        }
        return tempSt.toString();
    }
}