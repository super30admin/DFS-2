# Approach: Based on the character type we encounter everytime we iterate over the string we perform the following 
# Time : O(N * max(K)) where K is the digit 
# Space: O(N)

class Solution:
    def decodeString(self, s: str) -> str:
        
        if not s or len(s) == 0:
            return s
        
        num = 0
        current_str = ''
        num_stack = []
        str_stack = []
        
        for c in s:
            
            if c.isdigit():
                num = num*10 + int(c)
                
            elif c=='[':
                str_stack.append(current_str)
                num_stack.append(num)
                num = 0
                current_str = ''
                
            elif c==']':
                preNum = num_stack.pop()
                parent_str = str_stack.pop()
                current_str = parent_str + preNum * current_str
            
            else:
                current_str += c
                
        return current_str
                