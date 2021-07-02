# Iterative Solution
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
            return s
        num = 0
        currStr = ""
        numStack = deque()
        strStack = deque()
        for i in range(len(s)):
            if s[i].isnumeric():
                num = num * 10 + int(s[i])
                
            elif s[i] == '[':
                numStack.append(num)
                strStack.append(currStr)
                num = 0
                currStr = ''
               
            elif s[i].isalpha():
                currStr = currStr + s[i]
         
            elif s[i] == ']':
                times = numStack.pop()
                newStr = ''
                for i in range(times):
                    newStr += currStr
                currStr = strStack.pop() + newStr 
        return currStr

# Recursive Solution

class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
            return s
        num = 0
        currStr = ""
        while self.i < len(s):
            if s[self.i].isnumeric():
                num = num * 10 + int(s[self.i])
                self.i += 1  
                
            elif s[self.i] == '[':
                self.i += 1
                child = self.decodeString(s)
                newStr = ''
                for i in range(num):
                    newStr += child
                currStr += newStr
                num = 0  
                
            elif s[self.i].isalpha():
                currStr = currStr + s[self.i]
                self.i += 1
                
            elif s[self.i] == ']':
                self.i += 1
                return currStr
                
        return currStr

# Time Complexity : Max(K) * Max(n)  where K = max digit in string and n = Max length in string
# Space Complexity : Max charcters in stack