// Time - O(MaxKcount * n)
// Space - O(sum(MaxKcount * n))


class Solution {
    public String decodeString(String s) {


        if(s == null || s.length() == 0) return s;

        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;

        for( int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            // 4 cases
            // case 1 : char is a number
            if(Character.isDigit(c)) {
                // multiply the previous num by 10 and add the current num
                num = num * 10 + c - '0';

            }
            // case 2: if i hits opening bracket
            else if(c == '[') {

                // push the current num and current string into the stack and reset num and currStr with 0 and empty string
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();

            }

            // case 3: if i hits closing bracket
            else if(c == ']'){

                // pop the number from the the numstack to multiply it k times
                int noOfTimes = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k = 0; k < noOfTimes; k++) {
                    newStr.append(currStr);
                }

                // append it with the parent
                StringBuilder parent = strStack.pop();
                currStr = parent.append(newStr);
            }

            // case 4: if i hits a character
            else {
                currStr.append(c);

            }


        }
        // convert stringbuilder to string
        return currStr.toString();

    }
}