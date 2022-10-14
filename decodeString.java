class Solution {
    // T.C : O(n * k) where k is depth of string
    // S.C : O(n * k)
    // Executed
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();  // ""
            }
            else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            }
            else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

// Approach - 2
// Executed
class Solution {
    int i;
    public String decodeString(String s) {
        // T.C and S.C : O(n * k) where k is depth of string
        // recursive approach
        if (s == null || s.length() == 0)
            return "";
        
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i++;
            }
            else if (c == '[') {
                i++;
                String decoded = decodeString(s);
                // pop operation
                StringBuilder newStr = new StringBuilder();
               for (int j = 0; j < num; j++) {
                   newStr.append(decoded);
                }
                currStr.append(newStr);
                num = 0;
            }
            else if (c == ']') {
                i++;
                return currStr.toString();
            }
            else {
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}