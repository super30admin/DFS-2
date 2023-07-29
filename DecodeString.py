class Solution:
    def decodeString(self, s: str) -> str:
        charSt = []
        numSt = []
        currStr = ""
        currNum = 0

        for idx, ch in enumerate(s):
            if ch.isdigit():
                currNum = currNum * 10 + int(ch)
            elif ch == '[':
                numSt.append(currNum)
                charSt.append(currStr)
                currStr = ""
                currNum = 0
            elif ch == ']':
                num = numSt.pop()
                prevStr = charSt.pop()
                currStr = prevStr + currStr * num
                
            else:
                currStr += ch
        return currStr