'''
Problem2 (https://leetcode.com/problems/decode-string/)
'''

class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
            return ""

        num = 0
        currStr = []
        numSt = []
        strStack = []
        for i in range(len(s)):
            c = s[i]
            if c >= '0' and c <= '9':
                num = num * 10 + int(c)
            elif c == '[':
                strStack.append("".join(currStr))
                currStr.clear()
                numSt.append(num)
                num = 0
                
            elif c == ']':
                times = numSt.pop()
                newStr = []
                for i in range(times):
                    newStr.append("".join(currStr))
                currStr.clear()
                currStr.append(strStack.pop() + "".join(newStr))   
            else:
                currStr.append(c)
        return "".join(currStr)        

