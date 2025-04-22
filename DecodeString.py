# Time Complexity: O(n)
# Space Complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any problems while coding this: No

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        currentNum = 0
        currentStr = ""
        for i in s:
            if i == "[":
                stack.append(currentNum)
                stack.append(currentStr)
                currentStr = ""
                currentNum = 0

            elif i == "]":
                oldstr = stack.pop() 
                repeats = stack.pop() 
                currentStr = oldstr + repeats * currentStr 
            elif i.isdigit():
                currentNum = currentNum * 10 + int(i)
            else:
                currentStr += i

        return currentStr