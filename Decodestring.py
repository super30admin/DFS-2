# Time Complexity : O(mxn)
# Space Complexity : O(mxn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use stack and push every element based upon square brackets.

class Solution:
    def decodeString(self, s: str) -> str:
        numSt= []
        strSt= []
        cs=''
        cn=0
        for i in range(0, len(s)):
            c=s[i]
            if (c.isdigit() == True):
                cn=cn*10+int(c)-int("0")
            elif (c =="["):
                numSt.append(cn)
                strSt.append(cs)
                cs=""
                cn=0
            elif (c == "]"):
                count=numSt.pop()
                ns=""
                for k in range(0,count):
                    ns= ns+cs
                pt =strSt.pop()
                cs=pt+ns
            else:
                cs=cs+c
        return cs