'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(n) -- string count + int count 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''

class Solution:
    def decodeString(self, s: str) -> str:
        
        # Initialize currStr and num
        currStr = ''
        num = 0
        
        # Initialize stacks
        numStack = []
        strStack = []
        
        # Iterate the string
        for i in range(0,len(s)):
            
            # s[i] is a NUMBER
            if s[i].isdigit():
                num = num *10 + int(s[i])
                #print('Num is:\t',num)
                
                
            # s[i] is a STRING
            elif type(s[i]) == str and (s[i] != '[' and s[i] != ']' ) :
                currStr = currStr + s[i]
                #print('currentStr is:\t',currStr)
            
            # s[i] is a [
            elif s[i] == '[':
                # push the "num" and "currStr" to the stack and reset those values to default of 0 and '' resp
                numStack.append(num)
                num = 0
                
                strStack.append(currStr)
                currStr = ''
                
            # s[i] is a ]
            elif s[i] == ']':
                # pop  first from the "numStack", duplicate it, then pop from "strStack" and append it to to the "currStr"
                # pop from numStack and duplicate the currStr
                temp_num = numStack.pop()
                
                # print('currStr before is:\t',currStr)
                if temp_num > 0:
                    currStr = currStr * temp_num
                    
                # pop from strStack and prepend it
                temp_str = strStack.pop()
                currStr = temp_str + currStr
            
        
        # return currStr
        # print('Current STR is:\t',currStr)
        return currStr  
            