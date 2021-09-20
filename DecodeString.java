// TIME: O(Max(k)*n)
// SPACE: O(m + n)
// SUCCESS on LeetCode

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        
        int count = 0;
        StringBuilder curString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                numSt.push(count);
                strSt.push(curString);
                curString = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                int repeat = numSt.pop();
                StringBuilder decodedString = strSt.pop();
                for (int i = 0; i < repeat; i++) {
                    decodedString.append(curString);
                }
                curString = decodedString;
            } else {
                curString.append(c);
            }
        }
        
        return curString.toString();
    }
}
