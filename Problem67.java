// Time Complexity : O(n × k) where n is the length of the string and k is the maximum repeat coun
// Space Complexity : O(n x k)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
            } else if (ch == '[') {
                strSt.push(currStr);
                numSt.push(currNum);

                currNum = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                int num = numSt.pop();
                StringBuilder parentStr = strSt.pop();

                for (int k = 0; k < num; k++) {
                    parentStr.append(currStr);
                }

                currStr = parentStr;
            } else {
                currStr.append(ch);
            }
        } 

        return currStr.toString();
        
    }
}