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
    int i = 0;
    public String decodeString(String s) {
        if(s==null || s.length() == 0) return "";
        int num = 0;
        StringBuilder curr = new StringBuilder();
        while(i<s.length()) {
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
            } else if(c == '[') {
                String decode = decodeString(s);
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<num; i++) {
                    sb.append(decode);
                }
                curr.append(sb);
                num = 0;
            } else if( c == ']') {
                return curr.toString();
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}