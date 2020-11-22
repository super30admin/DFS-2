/* 394. Decode String
Time Complexity: O(n)
Space Complexity: O(n)

Approach: Maintain two stacks nums and string, numsStack and a stringStack
The number stacks stores number of times a future string ( a string that is in upcoming square brackets) needs to be processed at the top.
The strings stack contains all the past strings have been processed. These past strings needs to be contactenated with future strings to give out the resultant strings

know the logic, cant come up with this instantly. How is this dfs? since we process outwards from the innermost bracket to outermost when we are appending and creating a new string
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