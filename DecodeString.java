// Time Complexity : O(k*l) , k is the numbers in input string
// Space Complexity : O(k*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Iterative
class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if(c == '[') {
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if(c == ']') {
                int temp = numSt.pop();
                StringBuilder parent = strSt.pop();
                for(int j = 0; j < temp; j++) {
                    parent.append(currStr);
                }
                currStr = parent;
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
//Recursive
class DecodeString {
    int i = 0;
    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        while(i < s.length()) {
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if(c == '[') {
                String str = decodeString(s);
                for(int j = 0; j < currNum; j++) {
                    currStr.append(str);
                }
                currNum = 0;
            } else if(c == ']') {
                return currStr.toString();
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}