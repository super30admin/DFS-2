"""
Approach: 2 Stacks single iteration on string
Use 1 stack to keep track of strings we have seen thus far, and 2nd stack to add the numbers. 
Algorithm:
- If we see the current char as a number - use num = num * 10 + int(ch)
- If we see an opening bracket - push currStr and num to the respective stacks and re-init those to "" and 0
- If we see a closing bracket - pop the stack and join str from string stack with currStr*number popped from num stack
- Else currStr = ''.join([currStr,ch])
- Return currStr

TC O(N) - where N is the len of the final output - as we have to multiply to create the pieces of string
SC O(H) - maximum depth for `[]` brackets - is how much space we will use on the stack.
"""
class Solution:
    def decodeString(self, s: str) -> str:
        # base
        if not s:
            return ""
        # logic
        strSt, numSt = [], []
        currStr, num = "", 0
        
        for ch in s:
            if str.isnumeric(ch): # its a number
                num = num * 10 + int(ch)
            elif ch == "[":
                strSt.append(currStr)
                numSt.append(num)
                currStr, num = "", 0
            elif ch == "]":
                currStr = ''.join([strSt.pop(),currStr*numSt.pop()])
            else:
                currStr = ''.join([currStr,ch])
        return currStr
                
                
"""
Approach: Recursive approach, using global variable `i` for len of string
Initialize i = 0 globally, then while i< len(str), do:
- If char is number - do num = num * 10 + int(char) (here char is ~= str[i]), increase i
- if it is "[" - increase i , recursively call decodeStr
- if it is "]" - increase i, return curr str
- else append char(or s[i]) to currStr and increase i
Outside while loop, return currStr as final result

TC  O(maxK*N)  Max integer K * len of string - cause we traverse  string N and iterate over K times to decode it
SC  O (N) internal call stack space, it would not exceed length of input string
"""
class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        # base
        if not s:
            return ""
        # logic
        currStr, num = "", 0
        while self.i < len(s):
            if str.isnumeric(s[self.i]):
                num = num * 10 + int(s[self.i])
                self.i += 1
            elif s[self.i] == "[":
                self.i += 1
                decodedStr = self.decodeString(s)
                currStr = ''.join([currStr, decodedStr * num])
                num = 0
            elif s[self.i] == "]":
                self.i += 1
                return currStr
            else:
                currStr = ''.join([currStr, s[self.i]])
                self.i += 1
        # final result
        return currStr
                
                