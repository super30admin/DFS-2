// Time Complexity : O(max(k)n)
// Space Complexity :O(max(k)n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes i am still fuzzy on the logic, i was able to code it but not sure if i understood

/*
 * Appraoch
 * 
 * the string will have num, "[", "]" or a char
 * based on this we have to create the final string
 * num will represent how many time the baby string will be multipled by
 * 
 * so we will use 2 stack, 1 to keep track of the num and one to keep track of the string
 * 
 * we use 2 vars one cur num and another cur string
 * when we encouter "[" we push the cur num and string to stack and reset them
 * 
 * when we find "]" take the last added num from stack 
 * and appened the cur string that many times
 * and after that we append that string will the last string that was added to the string tack, as that is the parent string
 * 
 * and if we encounter a chr we just append that to the cur string 
 * 
 * in the end we return curent string
 * 
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder curSt = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                numSt.push(num);
                strSt.push(curSt);
                num = 0;
                curSt = new StringBuilder();

            } else if (ch == ']') {
                // decode the curBaby
                int cnum = numSt.pop();
                StringBuilder decodedString = new StringBuilder();
                for (int k = 0; k < cnum; k++) {
                    decodedString.append(curSt);
                }

                // combine the partent string
                StringBuilder parent = strSt.pop();
                curSt = parent.append(decodedString);
            } else {
                curSt.append(ch);
            }
        }
        return curSt.toString();
    }
}