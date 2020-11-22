#  Time Complexity : O(n) Length of decoded string 
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No 

# use the DFS (we have used stack solution for understanding) 
# got hrough the string check if number, [,] or character
# make two stacks string and number
# append the string we store in stack by numStack.pop number of times 

class Solution:
    def decodeString(self, s: str) -> str:
        
        if len(s) == 0: return ""
        
        inStr = []
        numArray = []
        st=""
        num = 0
        for i in s:
            
            if i.isnumeric(): #isnumeric gives true if string can be a number
                num = num*10 + int(i)
            
            elif i=="[":
                numArray.append(num)
                inStr.append(st)
                num = 0
                st = ""
            
            elif i=="]":
                times = numArray.pop()
                newString = ""
                for i in range(times):
                    newString += st
                st = inStr.pop()+newString
                
            
            else:  #if character
                st = st+i
        
        return st
                