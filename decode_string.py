# Time Complexity : Add - O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''

1. To decode the inner most string need to be explored so we use stack to pushing the current state
2. Initialy curr number and current string start off as empty "". AS we see a number it is added to curr_no
3. As we see a alphabet it is added to cur_str. When '[' comes the curr_no and curr_str is rest to "" before pushing them to
   stack
4. As we observe ']', the curr_str is multiplied by number popped and concataned with str popped

'''

from collections import deque
class Solution:
    def decodeString(self, s: str) -> str:
        
        if not s or len(s) < 1:
            return s
        
        stack = deque()
        
        curr_no = ""
        curr_str = ""
        for i in s:
            
    
            if i.isnumeric():
                curr_no += i
            
            elif i.isalpha():
                curr_str += i
            
            elif i == '[':
                stack.append((int(curr_no), curr_str))
                curr_no = ""
                curr_str = ""
                
            elif i == "]":
                prec_no, prec_str = stack.pop()
                curr_str = prec_str + (curr_str * prec_no)
                
        return curr_str
                
        
        
        
        