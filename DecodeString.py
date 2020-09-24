// Time Complexity : O(n)
// Space Complexity : O(maxValue)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution:
    def decodeString(self, s: str) -> str:

        stack = []; curNum = 0; curString = '' #use stack inorder to maintain order of brackets
        for c in s:
            if c == '[': # push cur string into stack
                stack.append(curString)
                stack.append(curNum)
                curString = ''
                curNum = 0
            elif c == ']': # calculate the string when ']' is seen
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num*curString
            elif c.isdigit(): # calculate until digit is done
                curNum = curNum*10 + int(c)
            else: #else keep on adding string
                curString += c
        return curString
                