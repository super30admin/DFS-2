#TC:0(N)
#SC:0(MIN(M,N))
class Solution:
    def decodeString(self, s: str) -> str:
        if(len(s) == 0):
            return 0
        cur = ''
        num = 0
        nums = []
        strng = []
        for i in range(len(s)):
            c = s[i]
            if(c.isdigit()):
                num = num * 10 + int(c)                
            elif(c == '['):
                nums.append(num)
                strng.append(cur)
                cur = ''
                num = 0
            elif(c == ']'):
                times = nums.pop()
                new = ''
                for j in range(times):
                    new += cur
                cur = strng.pop()+(new)
            else:
                cur+=c
                
        return cur 
        