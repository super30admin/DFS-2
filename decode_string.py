# Time Complexity : O(n * max(digit_present_in_string))
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    
    def decodeString(self, s: str) -> str:
        if not s: return ""
        curr_str = ""
        num = 0
        str_stack = []
        num_stack = []
        
        for i in range(len(s)):
            ch = s[i]
            if ch.isdigit():
                num = num*10 + int(ch)
            elif ch == '[':
                str_stack.append(curr_str)
                num_stack.append(num)
                
                # Reset. Otherwise it will concat to existing as per last condition.
                curr_str = ""
                num = 0        
            elif ch == ']':
                n = num_stack.pop()
                parent = str_stack.pop()
                
                new_str = ""
                for i in range(n):
                    new_str += curr_str
                curr_str = parent + new_str
            else:
                # if 'ch' is char. Have += incase of stings like bcd. 
                curr_str += ch
        
        return curr_str