'''
Time complexity: O(n + sum of numbers in string)
Space complexity: O(n)
'''
class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return s
        stackInt = []
        stackStr = []
        
        currStr = ""
        currNum = 0
        
        for ch in s:
            if ch.isdigit():
                currNum = currNum * 10 + int(ch)
            elif ch == '[':
                stackInt.append(currNum)
                stackStr.append(currStr)
                currNum = 0
                currStr = ""
            elif ch == ']':
                popped = stackInt.pop()
                temp = ""
                for x in range(popped):
                    temp = temp + currStr
                currStr = stackStr.pop()
                currStr = currStr + temp
            else: # encountered a character
                currStr = currStr + ch
        return currStr