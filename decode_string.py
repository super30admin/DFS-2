# time: O(n)
# space: O(n)
class Solution(object):
    def decodeString(self, s):
        numSt, strSt = [], []
        currNum = 0
        currStr = ""
        for i in range(len(s)):
            c = s[i]
            if c >= '0' and c <= '9':
                currNum = currNum * 10 + int(c)
            elif c == '[':
                numSt.append(currNum)
                strSt.append(currStr)
                currNum = 0
                currStr = ""
            elif c == ']':
                cnt = numSt.pop()
                baby = ""
                for i in range(cnt):
                    baby += currStr
                parent = strSt.pop()
                currStr = parent + baby
            else:
                currStr += c

        return currStr

