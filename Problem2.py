class Solution:
    def decodeString(self, s: str) -> str:
        numst = []
        strst = []
        currNum = 0
        currSt = []
        for char in s:
            if char.isdigit():
                currNum = currNum * 10 + int(char)
            elif char == '[' :
                numst.append(currNum)
                strst.append(currSt)
                currNum = 0
                currSt = []
            elif char == ']':
                num = numst.pop()
                baby = num * ''.join(currSt)
                parent = strst.pop()
                currSt = parent + list(baby)
            else:
                currSt.append(char)
        
        return ''.join(currSt)

        