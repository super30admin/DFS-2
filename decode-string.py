# Time Complexity : O(maxK * n) - k is the max number in s and n is len(s)
# Space Complexity : O(m + n) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
DFS
Iterate through the string and maintain 2 stacks,
one for number(count) and one for parentStr
Whenever we encounter "[", push the parentStr and count to respective stacks
Whenever we encounter "]", pop the parent and count and set currStr = parent + count*currStr
"""

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """

        strStack = []
        numStack = []

        currNum = 0
        currStr = ""

        for i in range(0, len(s)):
            if s[i] == "[":
                numStack.append(currNum)
                strStack.append(currStr)
                currNum = 0
                currStr = ""
            elif s[i] == "]":
                parent = strStack.pop()
                k = numStack.pop()
                baby = []
                for i in range(0, k):
                    baby.append(currStr)
                babyStr = "".join(baby)
                currStr = parent + babyStr
                print(currStr)
            elif s[i].isdigit():
                currNum = currNum * 10 + int(s[i])
            else:
                currStr = currStr + s[i]
        return currStr

