## Problem2 (https://leetcode.com/problems/decode-string/)

'''
TC = O(n)  every character is processed once
SC = O(n)  recursive call stack and string building
'''

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        currNum = 0
        currStr = ""

        for ch in s:
            if ch.isdigit():
                currNum = currNum * 10 + int(ch)
            elif ch == '[':
                stack.append((currStr, currNum))
                currStr = ""
                currNum = 0
            elif ch == ']':
                prev_string , repeat = stack.pop()
                currStr = prev_string + repeat * currStr
            else:
                currStr += ch
        return currStr
        