/*
Stack solution


Time	O(n × k)	   
Space	O(n)	           

*/

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
            } else if (ch == '[') {
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                //pop the num
                int cnt = numSt.pop();
                StringBuilder baby = new StringBuilder();
                for (int k = 0; k < cnt; k ++) {
                    baby.append(currStr);
                }
                //combine the baby with papa
                StringBuilder parent = strSt.pop();
                currStr = parent.append(baby);
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}