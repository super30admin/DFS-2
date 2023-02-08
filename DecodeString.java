// ########## Approach 1: Stacks ##########
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum*10 + c-'0';
            }
            else if(Character.isAlphabetic(c)){
                curStr.append(c);
            }
            else if(c=='['){
                numSt.push(curNum);
                strSt.push(curStr);
                curNum = 0;
                curStr = new StringBuilder();
            }
            else if(c==']'){
                int repeat = numSt.pop();
                StringBuilder decoded = new StringBuilder();
                for(int j=0; j<repeat; j++){
                    decoded.append(curStr);
                }
                StringBuilder pre = strSt.pop();
                curStr = pre.append(decoded);
            }
        }
        return curStr.toString();
    }
}

// ########## Approach 2: Recursion ##########
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    int i=0;
    public String decodeString(String s) {
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum*10 + c-'0';
                i++;
            }
            else if(Character.isAlphabetic(c)){
                curStr.append(c);
                i++;
            }
            else if(c=='['){
                i++;
                String child = decodeString(s);
                for(int i=0;i<curNum;i++){
                    curStr.append(child);
                }
                curNum = 0;
                i++;
            }
            else if(c==']'){
                return curStr.toString();
            }
        }
        return curStr.toString();
    }
}