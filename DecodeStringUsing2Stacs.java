// TC: O(max(k) x n)
// SC: O(no. of letters + no. of chars)
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if(c == '[') {
                count.push(k);
                str.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if(c == ']') {
                StringBuilder decode = str.pop();
                int currK = count.pop();
                while(currK > 0) {
                    decode.append(curr);
                    currK--;
                }
                curr = decode;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}