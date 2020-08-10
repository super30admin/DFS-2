# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

#Two solutions
class Solution:
    i = 0
    # Iterative
    def decodeString(self, s: str) -> str:
        num = 0
        tempStr = ''
        numStk = []
        strStk = []
        
        for i in s:
            # print(numStk, strStk, tempStr)
            if i.isdigit():
                num = num*10 + int(i)
            elif i == '[':
                numStk.append(num)
                strStk.append(tempStr)
                num = 0
                tempStr = ''
            elif i == ']':
                tempStr *= numStk.pop()
                tempStr = strStk.pop() + tempStr
            else:
                tempStr += i
                
        return tempStr
    
    #Recurssive
    def decodeString(self, s: str) -> str:
        if self.i >= len(s):
            return tempStr
        
        tempStr = ''
        
        if s[self.i].isdigit():
            self.num = self.num *10 + int(i)
            self.i += 1
        elif s[self.i] == '[':
            self.i += 1
        elif s[self.i] == ']':
            self.i += 1
        else:
            tempStr.append(s[self.i])