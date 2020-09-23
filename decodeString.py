# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
        
        if not s or len(s) == 0:
            return s
        
        n_stack = []
        s_stack = []
        c_num = 0
        c_str = ""
        
        for ch in s:
            
            if ch.isdigit():
                c_num = c_num*10 + int(ch)
            
            elif ch == "[":
                n_stack.append(c_num)
                s_stack.append(c_str)
                c_num = 0
                c_str = ""

            elif ch == "]":
                temp = ""
                t_num = n_stack.pop()
                for _ in range(t_num):
                    temp += c_str
                c_str = s_stack.pop() + temp
                
            else:
                c_str += ch

        return c_str
            