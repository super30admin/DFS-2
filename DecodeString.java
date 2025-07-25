// Both solutions O(n)
class Solution {
    public String decodeString(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int num = 0;
        StringBuilder curStr = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(curStr);
                curStr = new StringBuilder();

            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder str = new StringBuilder();
                for(int k = 0; k < times; ++k) {
                    str.append(curStr);
                }
                curStr = strStack.pop().append(str);
            } else {
                curStr.append(c);
            }

        }

        return curStr.toString();
        
    }

    int i;

    
    // Recursive
    public String decodeStringRecursive(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder cur = new StringBuilder();
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            ++i;
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // check the iterative soln. we are pushing into the stack. So call recursively.
                // After the call, pop happens. So what we do after pop in iterative comes here
                String decoded = decodeStringRecursive(s);

                for(int k = 0; k < num; ++k) {
                    cur.append(decoded);
                }

                num = 0; // reset num to 0 to start fresh.

            } else if (c == ']') { // ending of a section, so return the curString formed.
                return cur.toString();
            } else { // if character just append
                cur.append(c);
            }
        }
        return cur.toString();
    }
}