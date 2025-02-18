// Time Complexity : O (len(decodedString))
// Space Complexity : O (level of nesting)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
public class DecodeStrings {
    int i;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (i < s.length() && s.charAt(i) != ']') {
            if (!Character.isDigit(s.charAt(i))) {
                //append non-digit characters directly
                result.append(s.charAt(i++));
            } else {
                //get the number prefix
                int num;
                StringBuilder temp = new StringBuilder();
                while(s.charAt(i) != '[') {
                    temp.append(s.charAt(i++));
                }
                num = Integer.parseInt(temp.toString());

                // skip [
                i++;

                // recursively decode nested string
                String nestedString = decodeString(s);

                // skip ]
                i++;

                // put nested string in result num times
                result.repeat(nestedString, num);
            }
        }
        return result.toString();
    }
}
