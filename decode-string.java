//Time complexity: O(maxK * N), maximum value of k(decoded string) and n is actual length of string
//Space complexity: O(M + N), where m is the characters (a-z) and n is numbers(0-9)
class Solution {
    public String decodeString(String s) {
        if(s.length() == 0) {
            return s;   
        }
        Stack<StringBuilder> str_stack = new Stack<>();
        Stack<Integer> num_stack = new Stack<>();
        int len = s.length();
        int num;
        StringBuilder curr_str = new StringBuilder();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //if the character is digit
            if(Character.isDigit(c)) {
                //multiply the num by 10 and get the ascii value
                num = num * 10 + c - '0';
            }
            //if we encounter and opening bracket, push num and str to stack and reset the num pointer
            //curr string pointer
            else if(c == '[') {
                num_stack.push(num);
                str_stack.push(curr_str);
                num = 0;
                curr_str = new StringBuilder();
            }
            //if we encounter closing bracket, pop from the num stack
            //append the current string n times i.e decoded string
            else if(c == ']') {
                int times = num_stack.pop();
                StringBuilder decoded_str = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    decoded_str.append(curr_str);
                }
                //append the decoded string to parent
                curr_str = str_stack.pop().append(decoded_str);
                
            }
            else {
                curr_str.append(c);
            }
        }
        return curr_str.toString();
    }
}