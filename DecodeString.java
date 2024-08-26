//Time Complexity: O(n) where n is the length of the output
//Space Complexity: O(n)
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> sb = new Stack<>();
        Stack<Integer> si = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                sb.push(currString);
                si.push(currNum);
                currString = new StringBuilder();
                currNum = 0;
            } else if (c == ']') {
                int count = si.pop();
                StringBuilder baby = new StringBuilder();
                for (int k = 0; k < count; k++) {
                    baby.append(currString);
                }
                StringBuilder parent = sb.pop();
                currString = parent.append(baby);
            } else {
                currString.append(c);
            }
        }
        return currString.toString();
    }
}
