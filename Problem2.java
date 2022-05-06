import java.util.Stack;

//TC : O(n) -> where n is length of output
//SC : O(n) -> opening bracked in string
public class Problem2 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        int nums = 0;
        StringBuilder currString = new StringBuilder();
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                nums = nums * 10 + (c - '0');
            } else if (c == '[') {
                strStack.push(currString);
                intStack.push(nums);
                nums = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                int total = intStack.pop();
                StringBuilder newString = new StringBuilder();
                for (int j = 0; j < total; j++) {
                    newString.append(currString);
                }
                currString = strStack.pop().append(newString);
            } else {
                currString.append(c);
            }
        }
        return currString.toString();
    }
}
