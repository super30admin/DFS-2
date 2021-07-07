# Time Complexity : o(n)
# Space Complexity : o(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
class Solution:
    def decodeString(self, s: str) -> str:
        num=0
        string=''
        numStack=[]
        strStack=[]
        for i in s:
            if i.isalpha():
                string+=i
            elif i.isdigit():
                num=num*10+int(i)
            elif i=='[':
                numStack.append(num)
                strStack.append(string)
                num=0
                string=''
            elif i==']':
                curNum=numStack.pop()
                preString=strStack.pop()
                string=preString + curNum * string
        return string    
                
