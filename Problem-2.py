class Solution:
    def decodeString(self, s: str) -> str:

        if s is None or len(s)==0:
            return ""
        strStack = []
        numStack =[]
        curStr=""
        num =0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num*10 + int(c)
            elif c == '[':
                numStack.append(num)
                strStack.append(curStr)
                curStr=""
                num=0

            elif c == ']':
                times = numStack.pop()
                newStr =""
                for i in range(times):
                    newStr=newStr+curStr

                curStr =strStack.pop()+newStr

            else:
                curStr  = curStr+ c


        return curStr
