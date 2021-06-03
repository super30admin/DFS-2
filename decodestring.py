"""394. Decode String
Time Complexity: O(n)
Space Complexity: O(n) #stack size"""

class Solution:
    def decodeString(self, s: str) -> str:
        stack = [] 
        currentNum = 0
        currentStr = ""
        for ele in s:
            if ele == "[":
                stack.append(currentNum)
                stack.append(currentStr)
                currentStr = ""
                currentNum = 0
            elif ele == "]":
                oldstr = stack.pop() #pop old string out
                repeats = stack.pop() #pop the number of repeats
                currentStr = oldstr + repeats * currentStr 
            elif ele.isdigit():
                currentNum = currentNum * 10 + int(ele)
            else:
                currentStr += ele
        return currentStr



