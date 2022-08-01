"""
Runtime Complexity: O(length of the result string)
Space Complexity: O(number of opening brackets). Because we push the elements ton the stack only when we encounter a opening bracket.
Yes, the code worked on leetcode.
We have 4 options. We check if it's a digit, or opening , closing bracket or just the normal character. When its a open bracket we push the elements to the stack. When we encounter a closing 
bracket we just pop and multiply it and concatenate at the end.
"""

class Solution:
    def decodeString(self, s: str) -> str:
        if not s or len(s)==0:
            return ""
        num = 0
        current_str = ""
        num_stack = []
        str_stack = []
        size = len(s)
        
        for i in range(size):
            c = s[i]
            
            if (c.isdigit()):     #if the character is a digit
                num = num*10+ int(c)
            
            elif c =='[':       #case when the bracket starts we push to the stacks
                num_stack.append(num)
                str_stack.append(current_str)
                current_str = ""
                num = 0
            
            elif c == "]":      #case when the bracket closes
                k = num_stack.pop()
                new_str = []
                for i in range(k):
                    new_str.append(current_str)
                current_str = "".join(new_str)
                
                current_str= str_stack.pop() +current_str
            
            else:
                current_str+=c  #when its just a character
                
                
        return current_str
        