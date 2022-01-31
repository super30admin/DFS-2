
Time  :O(n*K)


class Solution {

    private int idx;

    public String decodeString(String s) {
        idx = 0;
        return helper(s);
    }

    private String helper(String s) {
        StringBuilder ans = new StringBuilder();
        int repeat = 0;
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (ch == ']') {
                return ans.toString();
            } else if (ch == '[') {
                ++idx;
                String str = helper(s);
                while (repeat > 0) {
                    ans.append(str);
                    --repeat;
                }
            } else if (Character.isDigit(ch)) {
                repeat = repeat * 10 + ch - '0';
            } else {
                ans.append(ch);
            }
            ++idx;
        }
        return ans.toString();
    }
}