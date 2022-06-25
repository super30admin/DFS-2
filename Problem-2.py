class Solution:
    def decodeString(self, s: str) -> str:
        if not s or len(s)==0:
            return s
        
        stackNum=[]
        stackStr=[]
        currStr=""
        currNum=0
        
        for char in s:
            if char.isalpha():
                currStr+=char                
                
            elif char.isdigit():
                currNum=currNum*10 + int(char)
                
            elif char=='[':
                stackNum.append(currNum)
                stackStr.append(currStr)
                
                currStr,currNum="",0
                
            elif char==']':
                popped=stackNum.pop()
                temp=""
                while popped>0:
                    temp=temp+currStr
                    popped-=1
                    
                currStr=stackStr.pop()
                currStr=currStr+temp
        return currStr
                