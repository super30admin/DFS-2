class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer> stackNum = new Stack<>();
        Stack<String> stackStr = new Stack<>();

        String currStr = "";
        int currNum = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            } else if (ch == '[') {
                stackNum.push(currNum);
                stackStr.push(currStr);

                currNum = 0;
                currStr = "";
            } else if (ch == ']') {
                int popped = stackNum.pop();
                String temp = "";
                for (int x = 0; x < popped; x++) {
                    temp += currStr;
                }

                currStr = stackStr.pop() + temp;

            } else {
                currStr += ch;
            }
        }

        return currStr;
    }
}

// TC : O(n)
// SC : O(n)

// optimizations - use string builder
// use for loop insted of for each loop