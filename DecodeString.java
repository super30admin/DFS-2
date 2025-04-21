import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int currNum = 0;
        StringBuilder currSt = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                numSt.push(currNum);
                strSt.push(currSt);
                currNum = 0;
                currSt = new StringBuilder();
            } else if (c == ']') {
                int ct = numSt.pop();
                StringBuilder parent = strSt.pop();
                StringBuilder baby = new StringBuilder();

                for (int k = 0; k < ct; k++) {
                    parent.append(currSt);
                }
                currSt = parent;
            } else {
                currSt.append(c);
            }
        }

        return currSt.toString();
    }
}

//TC: O(n*k), SC: O(n*k)
