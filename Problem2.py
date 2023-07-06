# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  We use 2 stacks to store the string and another to store the index of the element that we are processing.
# Anytime we hit "[" we go one level deeper into the stack and continue the same operation
# Anytime we hit "]" we out one level and also adjust the accumulated string correspondingly.
class Solution:
    def decodeString(self, s: str) -> str:
        
        numStack = []
        strStack = []
        currStr = ""
        currNum = 0

        for ch in s:
            if ch.isdigit():
                currNum = currNum*10 + int(ch)
            elif ch == "[":
                numStack.append(currNum)
                strStack.append(currStr)
                currStr = ""
                currNum = 0
            elif ch == "]":
                expandedStr = numStack.pop() * currStr
                currStr = strStack.pop() + expandedStr
                currNum = 0
            else:
                currStr += ch
            
        return currStr

