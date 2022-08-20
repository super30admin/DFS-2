#394. Decode String
"""
Time Complexity : O(len(currString))
Space Complexity : O(no of bracket pairs)
"""
class Solution:
    def decodeString(self, s: str) -> str:
        stringStack = []
        numStack = []
        currString = ""
        currNum = 0
        
        for ch in s:
            if ch.isdigit() == True:
                currNum = currNum *  10 + int(ch) 
            
            elif ch == '[':
                stringStack.append(currString)
                numStack.append(currNum)
                currString = ""
                currNum = 0
            
            elif ch == ']':
                times = numStack.pop()
                tempString = ""
                
                for _ in range(0, times):
                    tempString  = tempString + currString
                    
                parent = stringStack.pop()
                currString = parent + tempString
            
            else: #ch == any char
                currString = currString + ch
                
        return currString
