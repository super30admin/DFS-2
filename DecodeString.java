/*Given an encoded string, return its decoded string.
* TC O(maxK*N) SC O(maxK*N)
*/
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        Stack<Integer> intStk = new Stack<>();
        Stack<StringBuilder> charStk = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int digit = 0;
        for(int i = 0; i< s.length(); i++){
            Character c = s.charAt(i);
           
            if (Character.isDigit(c)) {
                digit = digit*10 + c - '0';
            }
            else if (c == '[') {
                intStk.push(digit);
                charStk.push(curr);
                digit = 0;
                curr = new StringBuilder();
            }
            else if (c == ']') {
                StringBuilder newStr = new StringBuilder();
                int count = intStk.pop();
                for (int j = 0; j< count;j++) {
                    newStr.append(curr);
                }
                curr = charStk.pop().append(newStr);
            }
            else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}

/** recursive solution */
class Solution {
    int i;
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        StringBuilder curr = new StringBuilder();
        int digit = 0;
        while(i< s.length()){
            Character c = s.charAt(i);
            i++;
            if (Character.isDigit(c)) {
                digit = digit*10 + c - '0';
            }
            else if (c == '[') {
                String decodedString = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j< digit;j++) {
                    newStr.append(decodedString);
                }
                curr.append(newStr);
                digit = 0;
            }
            else if (c == ']') {
                return curr.toString();
            }
            else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
