## Problem2 (https://leetcode.com/problems/decode-string/)

# Approach
# create 2 stacks. 1) numbers 2) characters. when i == digit, update curNum. when i == 'a', update curAlpha
# when i == [, push curNum and curAlpha to stack. when i = ], pop num, multiple with curAlpha. pop char, append curAlpha to char
# return curchar

# Time Complexity: O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
        curNum = 0
        curchar = ''
        nums = []
        chars = []

        for i in range(len(s)):
            if s[i].isnumeric():
                curNum = curNum * 10 + int(s[i])
            if s[i].isalpha():
                curchar+=s[i]
            if s[i] == '[':
                nums.append(curNum)
                chars.append(curchar)
                curNum = 0
                curchar = ''
            if s[i] == ']':
                n = nums.pop()
                curchar = n * curchar
                c = chars.pop()
                curchar = c+curchar
        return curchar
        

        