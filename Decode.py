#Time Complexity o(N) Length of Stack
# Space Complexity o(N) Lenght of Stack
class Solution:
    def decodeString(self, s: str) -> str:
        
        if s == None or len(s) == 0 :
            return s
        
#     String Stack
        st = []
#     Number stack
        stn = []
    
        curr = ""
        
        num = 0
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isnumeric():
                num = num*10 + int(c)
            elif c == '[':
                stn.append(num)
                st.append(curr)
                num = 0 
                curr = ""
            elif c == ']':
                k = stn.pop()
                decipher = ""
                for j in range(k):
                    decipher += curr
                
                parent = st.pop()
                
                curr = parent + decipher
                            
            else:
                curr += c
        return curr
            
                
        
        