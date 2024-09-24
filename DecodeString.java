import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            // push everything buy closing brackets to stack
            if (c != ']') {
                stack.push(c);
            } else {
                // step1
                // when we find ']', construct the string with in []
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter('c')) {
                    sb.insert(0,stack.pop());
                }
                // String with in '[]'
                String string = sb.toString();
                // remove '[]'
                if(!stack.isEmpty()) {
                    stack.pop();
                }


                // Step2
                // Find the number of times string with in '[]'should repeat
                int count = 1;
                if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count = Integer.valueOf(stack.pop());
                }

                // Step 3
                // construct string count many times and push it back to stack
                StringBuilder sbs = new StringBuilder();

                for (int m = 0; m < count; m++) {
                    sbs.append(sbs);
                }
                String stringBackToStack = sbs.toString();
                // push string back to stack.
                for (int k = 0; k < stringBackToStack.length(); k++) {
                    stack.push(stringBackToStack.charAt(k));
                }

            }

        }
        // Final fetching from stack
        StringBuilder decoded = new StringBuilder();
        while (!stack.isEmpty()) {
            decoded.append(stack.pop());
        }
        return decoded.toString();

    }
}
