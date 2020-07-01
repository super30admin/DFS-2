class Solution:
    def decodeString(self, s: str) -> str:
        if s==None or len(s)==0:
            return s
        numStack=[]
        num=0
        currStr=""
        strStack=[]
        for i in range(len(s)):
            c=s[i]
            #case1
            if(c.isdigit()):
                num=num*10+int(c)
            elif c=='[':
                numStack.append(num)
                strStack.append(currStr)
                num=0
                currStack=""
            elif c==']':
                times=numStack.pop()
                newString=""
                for k in range(times):
                    newString+=currStr
                currStr=strStack.pop()+newString
            else:
                currStr+=c
        return currStr
            
Space Complexity is O(n)
Time Complexity is O(n)
