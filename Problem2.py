# Time Complexity : O(n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def decodeString(self, s: str) -> str:
        StringStack=[]
        NumStack=[]
        CurStr=''
        CurrNum=0
        for char in s:
            if char.isdigit():
                CurrNum=CurrNum*10+int(char)
            elif char=='[':
                NumStack.append(CurrNum)
                StringStack.append(CurStr)
                CurStr=''
                CurrNum=0
            elif char==']':
                Num=NumStack.pop()
                Str=StringStack.pop()
                CurStr=Str+Num*CurStr
            else:
                CurStr+=char
        return CurStr
