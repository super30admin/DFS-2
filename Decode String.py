# TC : O(n)
# SC : O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        
        charStack = []
        numStack = []
        currString = ""
        num = 0
        
        for ch in s:
            if str.isnumeric(ch):
                num = num * 10 + int(ch)
            elif ch == "[":
                charStack.append(currString)
                numStack.append(num)
                currString, num = "", 0
            elif ch == "]":
                currString = ''.join([charStack.pop(),currString*numStack.pop()])
            else:
                currString = ''.join([currString,ch])
        return currString