class Solution:
    def decodeString(self, s: str) -> str:
        numstack=[]
        strstack=[]
        num=0
        currstr=''
        for char in s:
            if char=="[":
                numstack.append(num)
                strstack.append(currstr)
                num=0
                currstr=""
            elif char=="]":
                n=numstack.pop()
                s=''
                for i in range(n):
                    s+=currstr
                currstr=s
                p=strstack.pop()
                currstr=p+currstr
            elif char.isdigit():
                num=num*10+int(char)
            else:
                currstr+=char
        return currstr