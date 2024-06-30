/*
    LC - 394. Decode String
    TC - O(n)
    SC - O(n)
    Approach - Keeping track of the number & current string in the stack
        whenever we see the open [ then push to the stack.
        whenever we see the close ] then pop from the stack.
        whenever we see the digit, then convert it to number as it is string (using ASCII);
*/

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int num = 0;
        StringBuilder curr = new StringBuilder();
        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                i++;
                num = num * 10 + (c - '0');
            } else if(c == '[') {
                i++;
                String decoded = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int i=0; i<num; i++) {
                    newStr.append(decoded);
                }
                curr.append(newStr);
                num = 0;
            } else if(c == ']') {
                i++;
                return curr.toString();
            } else {
                i++;
                curr.append(c);
            }
        }
        return curr.toString();
    }
}