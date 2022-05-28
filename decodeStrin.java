// Time Complexity : O(N*max(k))
// Space Complexity : O(N*max(k)) - max of recursive calls
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class Solution {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int repeatTimes = 0;
        int i =0;
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> times = new Stack<>();
        while(i<s.length()) {
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)) {
                repeatTimes = repeatTimes*10+Character.getNumericValue(currChar);
            } else if(currChar == '[') {
                str.push(currStr);
                times.push(repeatTimes);
                repeatTimes = 0;
                currStr = new StringBuilder();
            } else if(currChar == ']') {
                StringBuilder temp = new StringBuilder();
                StringBuilder prevStr = str.pop();
                int currCnt = times.pop();
                // repeat currStr wrt last pushed repeatTimes
                for(int j =0;j<currCnt;j++) {
                    temp.append(currStr);
                }
                // set it as baby to currStr
                currStr = prevStr.append(temp);

            } else{
                currStr.append(currChar);
            }
            i++;
        }
        return currStr.toString();
    }
}