# Time Complexity: O(n*k) - len of decoded string
# Space Complexity: O(n) - len of string
# Approach: Use two stacks to process numbers and strings separately. 
# For every opening '[' append current string and number to respective stacks.
# For every closing ']' decode the current string by appending it to a new string k times and append this to the original string.
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        currStr = ''
        num = 0
        numStack = []
        strStack = []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num*10 + int(c)
            elif c == '[':
                numStack.append(num)
                strStack.append(currStr)
                currStr = ''
                num = 0
            elif c == ']':
                times = numStack.pop()
                newStr = ''
                for _ in range(times):
                    newStr += currStr
                currStr = strStack.pop() + newStr
            else:
                currStr += c
        return currStr