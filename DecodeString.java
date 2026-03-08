// Time complexity: O(n + k)
// space complexity: O(n + k)
// Ran succesfully on Leetcode: yes
class Solution {
    // keep track of the index of the string
    int idx = 0;
    public String decodeString(String s) {

        int currNum = 0;
        StringBuilder currString = new StringBuilder();


        while (idx < s.length()) {
            char ch = s.charAt(idx);
            idx++;
            // if char at index is [ use recussion to decode the string from the next index
            // if char at index is ]  return the curr string
            // if numeric add to currNum * 10
            // else append to currString
            if (ch == '[') {
                String baby = decodeString(s);
                for (int j = 0; j < currNum; j++) {
                    currString.append(baby);
                }
                currNum = 0;
            } else if (ch == ']') {
                return currString.toString();

            } else if (Character.isDigit(ch)) {
                currNum = 10 * currNum + Character.getNumericValue(ch);
            } else {
                currString.append(ch);
            }
        }

        // return the string at the end
        return currString.toString();
    }
}