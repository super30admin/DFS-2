class Solution:
    #Solution 1
    
    i = 0
    def decodeString(self, s: str) -> str:
        #Approach: DFS, recursion
        #Time Complexity: O(n * max(k)) //length of the decoded string
        #Space Complexity: O(n) // under the hood
        #where, n is the the length of the encoded string, and 
        #k are the multiplication factors
        
        if not s:
            return s
        
        currNum = 0
        currStr = ''
        
        while self.i < len(s):
            char = s[self.i]
            
            if char.isdigit():
                currNum = currNum * 10 + int(char)
                self.i += 1
            
            elif char.isalpha():
                currStr += char
                self.i += 1
                
            elif char == '[':
                self.i += 1
                
                innerStr = self.decodeString(s)
                for k in range(currNum):
                    currStr += innerStr
                
                currNum = 0
            
            elif char == ']':
                self.i += 1
                return currStr
        
        return currStr
    
    #Solution 2
    """
    def decodeString(self, s: str) -> str:
        #Approach: Two stacks
        #Time Complexity: O(n * max(k)) //length of the decoded string
        #Space Complexity: O(n)
        #where, n is the the length of the encoded string, and 
        #k are the multiplication factors
        
        numSt = []
        strSt = []
        
        currNum = 0
        currStr = ''
        
        for char in s:
            if char.isdigit():
                 currNum = currNum * 10 + int(char)
            
            elif char.isalpha():
                currStr += char
                
            elif char == '[':
                numSt.append(currNum)
                strSt.append(currStr)
                
                currNum = 0
                currStr = ''
            
            elif char == ']':
                times = numSt.pop()
                newStr = ''
                for i in range(times):
                    newStr += currStr
                currStr = strSt.pop() + newStr
        
        return currStr
    """