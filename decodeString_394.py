# // Time Complexity : O(n + number of pops)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class Solution:
    def decodeString(self, s: str) -> str:
        
        if s ==None or len(s) ==0:
            return ""
        
        #maintain two stacks: one to store numbers and other for strings
        numStack = []
        strStack = []
        
        #initialise num and str
        currNum = 0
        currStr = ""
        
        for char in s:
            
            #check if its a digit, then update the current number
            if char.isdigit():
                currNum = currNum*10 + int(char)
                
            #when open bracket is encountered, append the current string and number, then reset
            elif char == '[':
                numStack.append(currNum)
                strStack.append(currStr)
                currNum = 0
                currStr = ""
                
            #when closing bracket is encountered, pop string and number, then create a temp string until that point
            elif char  == ']':
                popped = numStack.pop()
                temp = ""
                for i in range(popped):
                    temp += currStr
                currStr = strStack.pop() 
                currStr += temp
                
            else:
                #update current string fro every number
                currStr += char
                
        return currStr
                
        