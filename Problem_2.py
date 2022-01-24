# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#1. step would be using a stack and also check if the number is a digit or not
#2. if it's a digit we can go ahead and check the opening and closing of the brackets
#3. we put the brackets into the stack and whatever is inside it we multiply it and save it to the output var.
class Solution:
    def decodeString(self, s: str) -> str:
        res, stack = "", []
        for char in s:
            if char != ']':
                stack.append(char)                 
            else:
                currStr, multiplier = '', ''
                while stack[-1] != '[':                      
                    currStr = stack.pop() + currStr
                stack.pop()                                  
                while len(stack) and stack[-1].isdigit():    
                    multiplier = stack.pop() + multiplier
                curr = int(multiplier) * currStr             
                for c in curr:
                    stack.append(c)                  
        return res + "".join(stack)