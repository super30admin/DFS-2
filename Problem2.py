"""
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution:
    def decodeString(self, s: str) -> str:
        cn = 0
        cs = ""
        num_st = [] #number stack
        al_st = [] #alphabet stack
        res = ""

        for c in s:
            if c.isdigit():
                cn = cn * 10 + int(c)
                
            elif c == "[": #add current number and string to stack and reset the values
                num_st.append(cn) 
                al_st.append(cs)
                cn = 0
                cs = ""
            
            elif c == "]": #pop from both stacks
                times = num_st.pop()
                ch = al_st.pop()
                cs = ch + times * cs #add popped char to old string repeated "times" times

            else: #when char is encountered
                cs = cs + c
                                    
        return cs