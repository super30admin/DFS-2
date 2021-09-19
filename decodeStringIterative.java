// Time Complexity: O(n) traversing whole string once
// Space Complexity: 2 Stacks taken for number and string => O(2n) => O(n)
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach:
// Idea here is to traverse each character and upon comparing if the character is
// a digit we assign the value to num as per single digit, double digit and so on
// if it is a character, we keep adding it to current stringbuilder
// in case we found [ we know that we are about to begin a child so we push the parent number and string to their stack and start num and curr fresh for child
// we continue this process until a closing ] is reached.
// once we get ] we pop the number from stack which is parent of respective string and append that string those number of times.
// finally we pop parent string builder and appent child to it and assign it to current
// finally we return string form of current
class Solution {
    public String decodeString(String s) {
        if(s==null || s.length() == 0) return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
            } else if(c == '[') {
                numStack.push(num);
                sbStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            } else if( c == ']') {
                int times = numStack.pop();
                StringBuilder insider = new StringBuilder();
                for(int j=0; j< times; j++) {
                    insider.append(curr);
                }
                curr = sbStack.pop().append(insider);
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}