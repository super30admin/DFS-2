#Time complexity: O(n)
#Space complexity: o(length of output string)
class Solution:
    def decodeString(self, s: str) -> str:
        strStack=[]
        numStack=[]
        currStr,num="",0
        for i in range(len(s)):
            if s[i]=='[':
                strStack.append(currStr)
                numStack.append(num)
                currStr=""
                num=0
            elif s[i]==']':
                count=numStack.pop()
                new_str=""
                for i in range(count):
                    new_str+=currStr
                parent=strStack.pop()
                currStr=parent+new_str
            elif s[i] in "0123456789":
                num = num*10+int(s[i])
            else:
                currStr+=s[i]
        return currStr
                
            
            
        