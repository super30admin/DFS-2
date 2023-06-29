class Solution:
    def decodeString(self, s: str) -> str:
        numSt = []
        strSt = []
        currSt = ""
        currNum = 0
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            elif c == "[":
                numSt.append(currNum)
                strSt.append(currSt)
                currSt = ""
                currNum = 0
            elif c == "]":
                count = numSt.pop()
                newStr = currSt * count
                parent = strSt.pop()
                currSt = parent + newStr
            else:
                currSt += c
        
        return currSt
