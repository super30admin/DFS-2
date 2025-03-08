# The code decodes a string where each segment has a pattern like k[string], by using a stack to store previously 
# encountered strings and multipliers. It processes the string character by character, building the final result by 
# expanding sections enclosed in square brackets.

# Time Complexity: O(n), where n is the length of the input string. Each character is processed once.
# Space Complexity: O(n) due to the stack used to store intermediate results and multipliers.

class Solution:
    def decodeString(self, s: str) -> str:
        res,num='',0
        st=[]
        for c in s:
            if c.isdigit():
                num=num*10+int(c)
            elif c =='[':
                st.append(res)
                st.append(num)
                res=''
                num=0
            elif c==']':
                pnum=st.pop()
                pstr=st.pop()
                res=pstr+pnum*res
            else:
                res+=c
        return res