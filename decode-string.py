#Time Complexity : O(n)
#Space Complexity : O(1)
class Solution:
    def decodeString(self, s: str) -> str:
        sn1 = ""
        newS = ""
        num = []
        st = []
        i = 0
        while i < len(s):
            if s[i].isalpha():
                sn1 += s[i]
            if s[i].isnumeric():
                numStr = ""
                while i < len(s) and s[i].isnumeric():
                    numStr += s[i]
                    i+=1
                num.append(int(numStr))
                continue
            elif s[i] == "[":
                st.append(sn1)
                sn1 = ""
            elif s[i] == "]":
                sn1 = st.pop() + num.pop()* sn1
            i+=1
        return sn1