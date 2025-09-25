# Time Complexity : O(n*k) where n is the length of the string and k is the max repeat count
# Space Complexity : O(n*k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition here is to have 2 stacks one for int and one for str and we keep track of currStr and currNum until we hit a closing bracket
# Once we hit a closing bracket thats when we decode the baby string and concat with the parent.
# Using curr string as list and joining it later to return the result is a part of optimization as strings are immutable.

class Solution:
    def decodeString(self, s: str) -> str:
        stackInt = []
        stackStr = []
        currStr = []
        currNum = 0

        for i in range(len(s)):
            if s[i].isdigit():
                currNum = currNum * 10 + int(s[i])
            elif s[i] == '[':
                stackInt.append(currNum)
                stackStr.append(currStr)
                currNum = 0
                currStr = []

            elif s[i] == ']':
                currInt = stackInt.pop()
                babyStr = []
                for i in range(currInt):
                    babyStr.extend(currStr)
                currStr = stackStr.pop() + babyStr

            else:  # is an alphabet
                currStr.append(s[i])

        return "".join(currStr)