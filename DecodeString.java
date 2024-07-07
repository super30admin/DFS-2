/***
 Approach - Using recursion
 TC - O(n)
 SC - O(n)
 */
class Solution {
    int i;
    public String decodeString(String s) {

        if(s == null || s.length() == 0)
            return "";

        StringBuilder currentStr = new StringBuilder();
        int num =0;

        while(i < s.length()) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                i++;
                num = num*10 + ch - '0';
            }

            else if(ch == '[') {
                i++;
                String decoded = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int i =0; i < num; i++) {
                    newStr.append(decoded);
                }

                currentStr.append(newStr);
                num =0;
            }

            else if(ch == ']') {
                i++;
                return currentStr.toString();
            }

            else {
                i++;
                currentStr.append(ch);
            }
        }

        return currentStr.toString();
    }
}