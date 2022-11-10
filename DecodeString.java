package s30.DFS1.DFS2;



// ALGO
// Write a recursive method that iterates over the string
// Call recursive method if you find '[' and multiply with its corresponding number

// Time Complexity: O(p * l) product of numbers as p and number of characters as l
// Space complexity: O (p * l)

public class DecodeString {

    private int index;
    public String decodeString(String s) {
        index=0;

        return decodeStringRec(s).toString();

    }

    private StringBuilder decodeStringRec(String s) {

        StringBuilder res = new StringBuilder();

        int num = 0;

        while (index < s.length()) {

            char ch = s.charAt(index);
            index++;

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                String subString = decodeStringRec(s).toString();

                while (num > 0) {
                    res.append(subString);
                    num--;
                }

            } else if (ch == ']') {
                return res;
            } else {
                res.append(ch);
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
