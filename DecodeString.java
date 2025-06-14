import java.util.*;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> curString = new ArrayList<>();
                while (stack.peek() != '[') {
                    curString.add(stack.pop());
                }
                stack.pop(); // remove '['
                int base = 1;
                int k = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                while (k != 0) {
                    for (int j = curString.size() - 1; j >= 0; j--) {
                        stack.push(curString.get(j));
                    }
                    k--;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        String input = "3[a2[c]]";
        String decoded = sol.decodeString(input);
        System.out.println("Decoded string: " + decoded); // Output: accaccacc
    }
}
