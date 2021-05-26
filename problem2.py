class Solution:
    def decodeString(self, s: str) -> str:
        num = 0
        curr = ""
        numstack = []
        strstack = []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit() == True:
                num = (num*10) + int(c)
            elif c == "[":
                numstack.append(num)
                strstack.append(curr)
                num = 0
                curr = ""
            elif c == "]":
                times = numstack.pop()
                newcurr = ""
                for i in range(times):
                    newcurr = newcurr + curr
                curr = newcurr
                curr = strstack.pop()+curr
            else:
                curr = curr + c

        return curr
        
