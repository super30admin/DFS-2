class Solution:
    def decodeString(self, s: str) -> str:
        currstr=""
        num=0
        strstack=[]
        numstack=[]
        for i in s:
            if ord(i)- ord('0') in range(10):
                num=num*10 + int(i)
            elif i=='[':
                numstack.append(num)
                strstack.append(currstr)
                num=0
                currstr=''
            elif i==']':
                times=numstack.pop()
                currstr*=times
                currstr=strstack.pop()+currstr
            else:
                currstr+=i
        return currstr