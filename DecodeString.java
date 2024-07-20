//Time Complexity: O(n) - resultant string - number of nested recursions.
//Space Complexity: O(n)

class Solution {
    int idx;

    public String decodeString(String s) {
        int currVal = 0;
        StringBuilder currString = new StringBuilder();

        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                currVal = 10 * currVal + c - '0';
                idx++;
            } else if (c == '[') {
                idx++;
                String temp = decodeString(s);
                for (int i = 0; i < currVal; i++)
                    currString.append(temp);
                currVal = 0;
            } else if (c == ']') {
                idx++;
                return currString.toString();

            } else if (Character.isLetter(c)) {
                currString.append(c);
                idx++;
            }

        }
        return currString.toString();
    }
}