//decode ways using 2 stacks solution
//Time Complexity O(k * n) where k is the maximum value by multiplying all num values

//here we are maintaining 2 stacks 1 for num of times we need to multiple and other stack on what to multiply (string).
//when we see [ brackets we push things to stack and ] we pop and multiply

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> sstack = new Stack<>();
        Stack<Integer> istack = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)) {
                num = num * 10 + currChar - '0';
            } else if(currChar == '[') {
                istack.push(num);
                sstack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if(currChar ==']') {
                int times = istack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    newStr.append(currStr);
                }
                StringBuilder poppedStr = sstack.pop();
                currStr = poppedStr.append(newStr);
            } else {
                currStr.append(currChar);
            }
        }
        return currStr.toString();
    }
}
