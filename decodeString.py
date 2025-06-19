# TC: O(nk), k is max product of nested numbers
# SC: O(n) , excluding output string

class Solution:
    def decodeString(self, s: str) -> str:
        cn=0
        cs=''
        str_stack=[]
        num_stack=[]
        for c in s:
            if c.isnumeric():
                cn=cn*10+int(c)
            elif c.isalpha():
                cs+=c

            elif c=='[':
                str_stack.append(cs)
                cs=''
                num_stack.append(cn)
                cn=0
            
            elif c==']':
                cs*=num_stack.pop()
                cs=str_stack.pop()+cs
        
        return cs

