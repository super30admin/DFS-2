# Solution: DFS using stack
# Leetcode: https://leetcode.com/problems/decode-string/
# Time Complexity : O(n) where n is the length of the string
# Space Complexity : O(n) for the stack
# Accepted on leetcode


class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        currentNum = 0
        currentStr = ""
        for i in s:
            if i == "[":
                stack.append(currentNum)
                stack.append(currentStr)
                currentStr = ""
                currentNum = 0
            elif i == "]":
                # First popped out is string because we pushed number first and string later when we encountered '['
                oldstr = stack.pop()
                repeats = stack.pop()
                # New current string is the previous string + current string repeated repeats times
                currentStr = oldstr + repeats * currentStr
            elif i.isdigit():
                currentNum = currentNum * 10 + int(i)
            else:
                currentStr += i
        return currentStr





