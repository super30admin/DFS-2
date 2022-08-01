# Time Complexity: O(len(s))
# Space Complexity: O(n) # n is number of open or close square brackets

from curses.ascii import isdigit
from unicodedata import digit


class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""

        currString = ""
        num = 0
        intStack = []
        strStack = []

        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':
                intStack.append(num)
                strStack.append(currString)
                currString = ""
                num = 0
            elif c == ']':
                times = intStack.pop()
                newString = ""
                for j in range(times):
                    newString = newString + currString
                currString = strStack.pop() + newString
            else:
                currString = currString + c

        return str(currString)
