
// Time Complexity : O(n)  where n is length of string
// Space Complexity :  O(h) h is height/depth of recursion
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// code decodes a string encoded with a specific pattern, utilizing recursion to process nested substrings
// within square brackets and repetition of substrings based on preceding numeric values.
// note this is 2nd problem
class Problem1 {

    int i = 0;

    public String decodeString(String s) {

        StringBuilder curStr = new StringBuilder();
        int num = 0;

        while(i < s.length()) {

            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
                i++;
            }
            else if(c == '[') {
                i++;
                String child = decodeString(s);
                while(num > 0) {
                    curStr.append(child);
                    num--;
                }
            }
            else if(c == ']') {
                i++;
                return curStr.toString();
            }
            else {
                curStr = curStr.append(c);
                i++;
            }
        }

        return curStr.toString();

    }
}
