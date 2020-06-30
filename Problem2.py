"""

    Name : Shahreen Shahjahan Psyche
    Time : O(N) 
    Space : O(N)

    This code ran successfully for all the test cases in Leetcode.

"""

from typing import List

class Solution:
    def decodeString(self, s: str) -> str:
        
        if not s:
            return ""
        
        num_stk = []
        str_stk = []
        
        curr_str = ""
        curr_num = 0
        
        for i in range(len(s)):
            
            if s[i].isdigit():
                curr_num = curr_num * 10 + int(s[i])
            elif(s[i] == '['):
                num_stk.append(curr_num)
                str_stk.append(curr_str)
                curr_num = 0
                curr_str = ""
            elif(s[i] == ']'):
                times = num_stk.pop()
                new_str = ""
                for _ in range(times):
                    new_str += (curr_str)
                curr_str = str_stk.pop()
                curr_str = curr_str + new_str
            else:
                curr_str += s[i]
                
        
        return curr_str
        