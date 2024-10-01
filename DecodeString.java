// Time complexity = O(multiply all the numbers)
// Space complexity = O(n), the length of the string

class Solution {
    public String decodeString(String s) {
        // maintain 2 stacks
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> charStack = new Stack<>();
        int currNum =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++ ) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum*10 + (c-'0');
            } else if(c=='[') {
                numStack.push(currNum);
                charStack.push(sb);
                sb = new StringBuilder();
                currNum =0;
            } else if(c==']') {
                int count = numStack.pop();
                StringBuilder baby = new StringBuilder();
                for(int j=0;j< count;j++) {
                    baby.append(sb);
                }
                StringBuilder parent = charStack.pop();
                sb = parent.append(baby);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}