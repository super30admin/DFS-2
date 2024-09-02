// Time Complexity : O(N) N - is the size of the output
// Space Complexity : O(M) - number of nesting
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.


class Solution {
    int idx = 0;
    public String decodeString(String s) {
        if(s.length() == 1) return s;

        StringBuilder curStr = new StringBuilder();
        int curNum = 0;

        while(idx < s.length()){
            char curC = s.charAt(idx);
            idx++;
            if(Character.isDigit(curC)){
                // idx++;
                curNum = curNum*10 + curC - '0';
            }else if(curC == '['){
                // idx++;
                String baby = decodeString(s);
                StringBuilder babyString = new StringBuilder();
                for(int k =0; k< curNum; k++){
                    babyString.append(baby);
                }
                curStr.append(babyString);
                curNum = 0;
            }else if(curC == ']'){
                // idx++;
                return curStr.toString();
            }else{
                curStr.append(curC);
                // idx++;
            }
            // idx++;
        }
        return curStr.toString();
    }

    public String decodeStringStack(String s) {
        if(s.length() == 1) return s;

        StringBuilder curStr = new StringBuilder();
        int curNum = 0;
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char curC = s.charAt(i);
            if(Character.isDigit(curC)){
                curNum = curNum*10 + curC - '0';
            }else if(curC == '['){
                strSt.push(curStr);
                numSt.push(curNum);
                curStr = new StringBuilder();
                curNum = 0;
            }else if(curC == ']'){
                int curIn = numSt.pop();
                StringBuilder b = new StringBuilder();
                while(curIn > 0){
                    b.append(curStr);
                    curIn--;
                }

                curStr = strSt.pop().append(b);
                // curStr = new StringBuilder();
            }else{
                curStr.append(curC);
            }
        }
        return curStr.toString();
    }
}