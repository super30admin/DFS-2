// Time Complexity :O(n)+maximum integer
// Space Complexity :largest number of nested brackets
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :took a lot of time to code

//we are using stack of stringbuilder and integer to store parentString and num of repetetions,
//whenever we detect a [, we push number and parent string inside stacks and while we detect ], we pop the parent and num
//we repeat currString number times and append it to parent string at the end, will return currentString

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        Stack<StringBuilder> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder parString = new StringBuilder();
        StringBuilder currSt = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                st.push(currSt);
                numSt.push(num);
                num = 0;
                currSt = new StringBuilder();
            } else if (c == ']') {
                parString = st.pop();
                num = numSt.pop();
                StringBuilder repStr = new StringBuilder();
                for (int k = 0; k < num; k++) {
                    repStr.append(currSt);
                }
                parString.append(repStr);
                currSt = parString;
                num = 0;
            } else {
                currSt.append(c);
            }
        }
        return currSt.toString();
    }
}

// -----------------------Recursion-----------------------------------------------
// Time Complexity :O(n)+max integer
// Space Complexity :O max no of nested braces
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :took too much time to understand

// we are keeping a global variable, when we encounter [, we call recursive
// method to get decoded child ie. nested bracket's decoded value and repeat
// that num of times
// when we encounter ], we return the currString as it will be repeated num time
// in parent method call
class Solution {
    private int i;

    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        StringBuilder currSt = new StringBuilder();
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i++;
            } else if (c == '[') {
                i++;
                String decoded = decodeString(s);
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < num; k++) {
                    sb.append(decoded);
                }
                // add to parent string
                currSt.append(sb);
                num = 0;
            } else if (c == ']') {
                i++;
                return currSt.toString();
                // num=0;
            } else {
                currSt.append(c);
                i++;
            }
        }
        return currSt.toString();
    }
}