class Solution:
    def decodeString(self, s: str) -> str:
        curr = ""
        num = 0
        numstack = []
        strstack = []
       
        for i in range(len(s)):
            if s[i].isdigit():
                num = num*10 + int(s[i])
            elif s[i] == "[":
                numstack.append(num)
                strstack.append(curr)
                curr = ""
                num = 0
            elif s[i] == "]":
                times = numstack.pop()
                newstr = strstack.pop()
                curr = newstr + times*curr
            else:
                curr += s[i]
        return curr

#TC: O(n)
#SC: O(m+n)