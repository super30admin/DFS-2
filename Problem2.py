class Solution:
    # Time Complexity:O(N*k) where k is length of concat operation
    # Space Complexity:O(N)
    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = ""
        strSt = []
        numSt = []
        for i in range(0, len(s)):
            c = s[i]
            if c.isdigit():
                currNum = currNum * 10 + (ord(c) - ord("0"))
            elif c == "[":
                strSt.append(currStr)
                numSt.append(currNum)
                currStr = ""
                currNum = 0
            elif c == "]":
                temp = strSt.pop()
                repeat = numSt.pop()
                currStr = temp + currStr * repeat
            else:
                currStr += c
        return currStr
