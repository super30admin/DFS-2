/*
class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return s
        curString = ""
        num = 0
        numStack = []
        stringStack = []
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + ord(s[i]) - ord('0')
                
            elif s[i] == '[':
                numStack.append(num)
                stringStack.append(curString)
                num = 0
                curString = ""
                
            elif s[i] == ']':
                times = numStack.pop()
                newString = ""
                for j in range(times):
                    newString += curString
                curString = stringStack.pop() + newString
            else:
                curString += s[i]
        return curString
*/
/*
class Solution {
    int i;
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        StringBuilder curString = new StringBuilder();
        int num = 0;
        
        while (i < s.length()){
            char c = s.charAt(i);
            i++;
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            
            else if (c == '['){
                String returned = decodeString(s);
                StringBuilder newString = new StringBuilder();
                for (int j=0; j<num; j++){
                    newString.append(returned);
                }
                curString.append(newString);
                num = 0;
            }
            
            else if (c == ']'){
                return curString.toString();
            }
            
            else {
                curString.append(c);
            }
        }
         return curString.toString();
    }
}
*/

// Time Complexity : O(n) where n is length of output string
// Space Complexity : O(m) where m is length of input string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I maintained two stacks, one for numbers and other for strings

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        StringBuilder curString = new StringBuilder();
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        int num = 0;
        
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if (c == '['){
                nums.push(num);
                strings.push(curString);
                num = 0;
                curString = new StringBuilder();
            }
            
            else if (c == ']'){
                int times = nums.pop();
                StringBuilder newString = new StringBuilder();
                for (int j=0; j<times; j++){
                    newString.append(curString);
                }
                curString = strings.pop().append(newString);
            }
            
            else{
                curString.append(c);
            }
        }
         return curString.toString();
    }
}
        