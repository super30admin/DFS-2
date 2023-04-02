# Time complexity - length of output string
# Space Complexity - O(m + n), m is number substrings and n is number of numbers
class Solution:
    def decodeString(self, s: str) -> str:
        stackSt = []
        stackN = []
        currNum = 0
        currStr = ""
        for each in s:
            if each.isdigit(): 
                currNum = currNum * 10 + int(each)
            elif each == '[':
                stackSt.append(currStr)
                stackN.append(currNum) 
                currNum = 0
                currStr = ""
            elif each == ']':
                count = stackN.pop()
                child = currStr * count
                currStr = stackSt.pop() + child
            else:
                currStr += each
        return currStr


# single stack

class Solution:
    def decodeString(self, s: str) -> str:
        stackSt = []
        currNum = 0
        currStr = ""
        for each in s:
            if each.isdigit(): 
                currNum = currNum * 10 + int(each)
            elif each == '[':
                stackSt.append([currStr,currNum])
                currNum = 0
                currStr = ""
            elif each == ']':
                val = stackSt.pop()
                count = val[1]
                child = currStr * count
                currStr = val[0] + child
            else:
                currStr += each
        return currStr

