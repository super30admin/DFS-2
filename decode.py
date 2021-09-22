class Solution:
    #TC O(mn)
    #SC O(mn) where m is number of time string is repated
    def decodeString(self, s: str) -> str:
        if s is None or len(s) ==0 :
            return s
        numlst = []
        strlst = []
        num = 0
        curstr = ""
        strlst.append(s)
        for cs in s:
            if cs.isdigit():
                num = num * 10 + (ord(cs) - ord('0'))
            elif cs == '[':
                numlst.append(num)
                strlst.append(curstr)
                num = 0
                curstr = ""
            elif cs == ']':
                times = numlst.pop()
                newstr =  [curstr for i in range(times)]
                old = strlst.pop()
                curstr = old + "".join(newstr) 
            else:
                curstr += cs
        return curstr
