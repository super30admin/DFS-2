import java.util.Stack;

// TC: O(n) as all the characters are visited.
// SC: O(n) as stacks are used which counts as a extra space
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(decodeString("3[a2[c]]")); // accaccacc
        System.out.println(decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
