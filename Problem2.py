# Time Complexity : O(number of characters in string)
# Space Complexity : O(number of characters in string)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
        num = []
        strng = []
        curr = 0
        currstr = ""

        for i in range(len(s)):
            c = s[i]

            if c.isdigit():
                curr *= 10
                curr += int(c)
            elif c == '[':
                strng.append(currstr)
                num.append(curr)
                currstr = ''
                curr = 0
            elif c == ']':
                times = num.pop()
                str1 = ''
                for i in range(times):
                    str1 += currstr
                currstr = strng.pop()
                currstr += str1
            else:
                currstr += c
        return currstr