// TC: O(max(k) x n)
// SC: O(n)
class Solution {
    int index = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ']') {
            if(!Character.isDigit(s.charAt(index))) {
                result.append(s.charAt(index));
                index++;
            } else {
                int k = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++;
                String decode = decodeString(s);
                index++;
                while(k > 0) {
                    result.append(decode);
                    k--;
                }
            }
        }
        return new String(result);
    }
}