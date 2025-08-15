// Time Complexity : O(n + totalOutputLength) here n for parsing string & totalOutputLength for building output string
// Space Complexity : O(n + totalOutputLength) here n for parsing string & totalOutputLength for building output string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Using DFS Iteration
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int n = s.length();
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        for(int i=0; i<n ;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c -'0';
            }
            else if(c == '['){
                numSt.push(num);
                strSt.push(currStr);
                num=0;
                currStr = new StringBuilder();
            }
            else if(c == ']'){
                int cnt = numSt.pop();
                StringBuilder decodedStr = new StringBuilder();
                for(int k=0; k< cnt; k++){
                    decodedStr.append(currStr);
                }
                currStr = strSt.pop().append(decodedStr);
            }else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

