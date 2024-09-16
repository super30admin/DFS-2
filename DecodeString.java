// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int index = 0;

        while(index < s.length()) {

            if(Character.isDigit(s.charAt(index))) {
                int num = 0;
                while(Character.isDigit(s.charAt(index))) {
                    num = (num* 10) + (s.charAt(index) - '0');
                    index++;
                }
                count.push(num);
            } else if(s.charAt(index) == '[') {
                result.push(res);
                res = "";
                index++;
            } else if(s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int cnt = count.pop();
                for(int i = 0; i< cnt; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            } else {
                res += s.charAt(index);
                index++;
            }
        }

        return res;
    }
}