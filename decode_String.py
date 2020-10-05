// Time Complexity : O(N)
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



def decodeString(self, s: str) -> str:
        
        if not s:
            return ""
        
        curStr = ""
        curNum = ""
        
        strStack = []
        numStack = []
        
        for c in s:
            if c.isdigit():
                curNum += c
                
            elif c == "[":
                numStack.append(int(curNum))
                strStack.append(curStr)
                
                curNum = ""
                curStr = ""
            
            elif c == "]":
                popNum = numStack.pop()
                newStr = curStr * popNum
                
                curStr = strStack.pop()
                curStr += newStr
                
            else:
                curStr += c
        
        return curStr
