# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#saving currNum in num stack and currStr in string stack and when we encounter ] pop and add to currstring stack
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) <= 1:
            return s
        nSt = []
        sSt = []
        currString = ""
        num = 0
        
        for i in range(len(s)):
            
            if s[i].isnumeric():
                num  = 10*num + int(s[i])
            
            elif s[i] == "[":
                nSt.append(num)
                sSt.append(currString)
                num = 0
                currString = ""
                    
            
            elif s[i] == "]":
                times = nSt.pop()
                newStr = ""
                for j in range(times):
                    newStr += currString
                currString = sSt.pop()
                currString += newStr
                
            else:
                currString += s[i]
        return currString
	


    