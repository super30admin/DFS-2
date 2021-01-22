// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder t = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n;) {
            if (Character.isDigit(s.charAt(i))) {
                stack.addLast(t.toString());
                t.setLength(0);

                while (i < n && Character.isDigit(s.charAt(i))) {
                    t.append(s.charAt(i++));
                }
                stack.addLast(t.toString());
                t.setLength(0);
            } else {
                if (s.charAt(i) == '[') {
                    i++;
                } else if (s.charAt(i) == ']') {
                    int r = Integer.parseInt(stack.pollLast());
                    String r_string = t.toString();
                    while (r-- > 1) {
                        t.append(r_string);
                    }

                    String top = stack.pollLast();
                    String temp = t.toString();
                    t.setLength(0);
                    t.append(top);
                    t.append(temp);        
                    i++;

                } else {
                    t.append(s.charAt(i));
                    i++;
                }
            }
        }
        if (t.length() > 0) {
            stack.addLast(t.toString());
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pollFirst());
        }
        return res.toString();
    }
}