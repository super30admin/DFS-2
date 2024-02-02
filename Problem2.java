//Accepted on LT
//Maintain 2 stacks one for int and one for string and [] , and do controlled poping

class Solution {
    public String decodeString(String s) {
        Stack<Integer> si = new Stack<>();
        Stack<String> ss = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                ss.push(String.valueOf(c));
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                si.push(num);
            } else if (c == '[') {
                ss.push("[");
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();

                while (!ss.isEmpty() && !ss.peek().equals("[")) {
                    temp.insert(0, ss.pop());
                }
                ss.pop();

                int n = si.pop();
                String repeatedString = temp.toString().repeat(n);
                ss.push(repeatedString);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!ss.isEmpty()) {
            result.insert(0, ss.pop());
        }

        return result.toString();
    }
}