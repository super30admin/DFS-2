"""
problem 2: decode string
TC: O(N) where N is the length of the string
SC: O(N) where N is the length of the string
"""

class Solution:
    def decodeString(self, s: str) -> str:

        num = 0
        curr_str = ""
        stk = []
        i = 0

        while i < len(s):
            if s[i] == "[":
                stk.append(num)
                stk.append(curr_str)
                curr_str = ""
                num = 0

            elif s[i] == "]":
                top_str = stk.pop()
                times = stk.pop()
                curr_str = top_str + times * curr_str

            elif s[i].isalpha():
                curr_str += s[i]

            else:
                num = num * 10 + int(s[i])

            i += 1

        return curr_str