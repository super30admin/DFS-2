time complexity: O(n)
space complexity: O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        if s==None or len(s)==0: return ""
        
        num=0
        currStr=""
        strStack=[]
        numStack=[]
        for i in s:
            if i.isdigit():
                num=(num*10)+int(i)
                
            elif i=="[":
                strStack.append(currStr)
                numStack.append(num)
                num=0
                currStr=""
            elif i=="]":
                times=numStack.pop()
                newStr=currStr*times
                
                currStr=strStack.pop()+newStr
                
            else:
                currStr=currStr+i
                
        return currStr