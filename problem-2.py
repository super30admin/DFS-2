# Time: maxNo*O(n)
# Space: O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        st = []
        
        for i in range(len(s)):
            if s[i] =="]":
                
                # form string
                tempstr= ""
                while st and st[-1]!="[":
                    tempstr = st.pop()+tempstr
                
                #top is a "[", so pop
                st.pop()
                
                #try to form the number
                numstr = ""
                while st and st[-1].isdigit():
                    numstr = st.pop()+numstr
                
                num = int(numstr)
                st.append(num*tempstr)
            else:
                st.append(s[i])
        
        return "".join(st)