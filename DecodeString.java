// Time Complexity : O(length of the output string)
// Space Complexity : O(number of the brackets) for stack and O(m) for recursion where m is maximum depth of nested brackets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using Stack , we iterate over the string. when its a number we count the digits. 
//  when we see a '[',we encounter a child, we push the current string and current count to stack and reset them
// current is to count the parent node
// when we see a ']', we multiple curStr with curcnt and append to the parent string from the stack

// Using Recursion, we use a global index to track the position in the string.
// recursion takes care of the nested brackets and call everytime it encounters a ']' and returns at ']'

class Solution {

    int i=0;
    public String decodeStringRecursion(String s) {
        StringBuilder curStr = new StringBuilder();
        int curCnt = 0;

        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curCnt = curCnt*10 + ch-'0';
                i++;
            }
            else if(ch=='['){
                i++;
                String baby = decodeStringRecursion(s);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<curCnt;j++)
                    sb.append(baby);
                curStr.append(sb);
                curCnt = 0;
            } 
            else if (ch == ']'){
                i++;
                return curStr.toString();
            }
            else{
                curStr.append(ch);
                i++;
            }
        }

        return curStr.toString();
    }

    public String decodeString(String s) {
        Stack<StringBuilder> strs = new Stack();
        Stack<Integer> ints = new Stack();
        StringBuilder curStr = new StringBuilder("");

        int curCnt = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curCnt = curCnt*10 + ch-'0';
            }
            else if(ch=='['){
                strs.push(new StringBuilder(curStr));
                curStr = new StringBuilder();
                ints.push(curCnt);
                curCnt = 0;
            } 
            else if (ch == ']'){
                StringBuilder newStr = strs.pop();
                int times = ints.pop();
                for(int j=0;j<times;j++)
                    newStr.append(curStr);
                curStr = newStr;
            }
            else{
                curStr.append(ch);
            }
        }

        return curStr.toString();
    }
}