/*Time Complexity: O(n)
Space Complexity: O(n)
Accepted on LeetCode: Yes
Approach: DFS Solution: We create two stacks , one for numbers and other for the string, we process the input outwards from the innermost bracket to outermost bracket where we keep appending to it.
*/

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String curStr = "";
        int curNum = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum * 10 + c - '0';
            }else if(c == '['){
                numStack.push(curNum);
                strStack.push(curStr);
                curNum = 0;
                curStr = "";
            }else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k=0; k<times; k++){
                    newStr.append(curStr);
                }
                curStr = strStack.pop();
                curStr += newStr;
            }else{
                curStr += c;
            }
        }
        return curStr;
    }
} 