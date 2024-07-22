// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class DecodeString {
    public String decodeString(String s) {

        Stack<Integer> currNumStack = new Stack<>();
        Stack<StringBuilder> currStrStack = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if(c == '['){
                currNumStack.push(currNum);
                currStrStack.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if(c == ']') {
                int count = currNumStack.pop();
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < count; j++) {
                    str.append(currStr);
                }
                // append parent to the string
                StringBuilder parentStr = currStrStack.pop();
                currStr = parentStr.append(str);
            } else {
                // when character is alphabet
                currStr.append(c);
            }
        }

        return currStr.toString();

    }
}

// using recursion
class DecodeString {
    int idx;

    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
                idx++;
            } else if (c == '[') {
                // child string starts, decoding the child string
                idx++;
                String childStr = decodeString(s);
                // append to parent
                for (int i = 0; i < currNum; i++) {
                    currStr.append(childStr);
                }
                currNum = 0;
            } else if (c == ']') {
                idx++;
                return currStr.toString();
            } else {
                // when character is alphabet
                idx++;
                currStr.append(c);
            }
        }

        return currStr.toString();

    }
}