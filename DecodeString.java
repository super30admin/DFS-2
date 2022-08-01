// Time Complexity : O(n), where n is the length of the result string
// Space Complexity : O(m), where m is the length of the max substring within braces
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class DecodeString {
    int i;
    public String decodeString(String s) {
        //base case
        if(s == null || s.length() == 0) return "";

        StringBuilder currString = new StringBuilder();
        int num = 0;

        //DFS
        // Stack<StringBuilder> strStack = new Stack<>();
        // Stack<Integer> numStack = new Stack<>();
        // for(int i = 0; i< s.length(); i++) {
        //     char c = s.charAt(i);
        //     if(Character.isDigit(c)) {
        //         num = num * 10 + (c-'0');
        //     } else if (c == '[') {
        //         strStack.push(currString);
        //         numStack.push(num);
        //         currString = new StringBuilder();
        //         num = 0;
        //     } else if (c == ']') {
        //         int times = numStack.pop();
        //         StringBuilder newStr = new StringBuilder();
        //         for(int j=0; j<times; j++) {
        //             newStr.append(currString);
        //         }
        //         currString = strStack.pop().append(newStr);
        //     } else {
        //         currString.append(c);
        //     }
        // }
        // return currString.toString();

        //Recursion

        while(i< s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c-'0';
                i++;
            } else if (c == '[') {
                i++;
                String decodedString = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int j=0; j<num; j++) {
                    newStr.append(decodedString);
                }
                currString.append(newStr);
                num = 0;
            } else if (c == ']') {
                i++;
                return currString.toString();
            } else {
                currString.append(c);
                i++;
            }
        }
        return currString.toString();
    }
}