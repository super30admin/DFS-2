# Time complexity - O(n * max(number in the input string))
# Space complexity - O(n * max(number in the input string))

# Approach - Maintain two stacks, one for number, other for string, for an opening bracket, the current num
# and str get appended to the respective stacks and the variables are cleared. In case of closing bracket,
# pop elements from stack, multiply the current str with the num popped and then add it to the str popped.
# This now becomes our new current str.

class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        strSt = []
        numSt = []
        currNum = 0
        currStr = [] # basically empty string

        for i in s:
            if i >= '0' and i <= '9':
                currNum = currNum * 10 + int(i) # Note, not i, but int(i)
            
            elif i == "[":
                strSt.append("".join(currStr))
                numSt.append(currNum)
                currNum = 0
                currStr.clear()
            
            elif i == "]":
                times = numSt.pop()
                newStr = currStr * times
                currStr.clear()
                parent = strSt.pop()
                currStr.append(parent + "".join(newStr))
            
            else:
                currStr.append(i)
        
        return "".join(currStr)