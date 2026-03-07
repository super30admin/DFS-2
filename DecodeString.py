# Time Complexity : O(n*k)
# Space Complexity : O(n*k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : As we loop through the string, we build numbers and characters until we hit an opening bracket.
# Then we push the number and current string into stacks and start fresh to build the enclosed string.
# When we hit a closing bracket, we pop the count and previous string, repeat the inner string, and stitch it back to continue.

class Solution:
    def decodeString(self, s: str) -> str:
        strSt, numSt = [], []
        currNum, currStr = 0, []

        for i in range(len(s)):
            c = s[i]

            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == '[':
                strSt.append(currStr)
                numSt.append(currNum)

                currNum = 0
                currStr = []
            elif c == ']':
                cnt = numSt.pop()
                parent = strSt.pop()

                for k in range(cnt):
                    parent.extend(currStr)

                currStr = parent
            else:
                currStr.append(c)

        return ''.join(currStr)
        