#Time Complexity:O(mn) (where n = len of string, m = max num in the string)
#Space Complexity:O(n) (where n = len of the given string)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach: using 2 stacks: one for char/letter and other for the number

class Solution:
    def decodeString(self, s: str) -> str:
        
        if not s or len(s) == 0:
            return s
        
        num = 0
        curr_str = ''
        num_stack = []
        str_stack = []
        
        for c in s:
            
            if c.isdigit():
                num = num*10 + int(c)
                
            elif c=='[':
                str_stack.append(curr_str)
                num_stack.append(num)
                num = 0
                curr_str = ''
                
            elif c==']':
                pre_num = num_stack.pop()
                parent_str = str_stack.pop()
                curr_str = parent_str + pre_num * curr_str
            
            else:
                curr_str += c
                
        return curr_str