# 394 decode string
# time - O(n*Max(k))
#space - O(m + n +k)
class Solution:
    def decodeString(self, s: str) -> str:
        
        currString = ""
        currNum = 0
        
        numStack = []
        strStack = []
        
        for char in s:
            
            if char.isdigit():
                print(char)
                currNum = currNum *10 + int(char)
            
            elif (char.isalpha()):
                print(char)
                currString = currString + char
                
            elif (char == "["):
                
                strStack.append(currString)
                numStack.append(currNum)
                
                currNum = 0
                currString = ""
                
            else:
                
                poppedNum = numStack.pop()
                temp = ""
                
                for i in range(poppedNum):
                    
                    temp = temp + currString
                
                currString = strStack.pop() + temp
        
        return currString        
                
                