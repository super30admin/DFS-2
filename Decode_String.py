# TC: O(L)
# SC: O(L)

class Solution:
    def decodeString(self, s: str) -> str:
        str1=[]
        num=[]
        curstr=""
        curnum=0
        integers=[0,1,2,3,4,5,6,7,8,9]
        for i in range(0,len(s)):
            if ord(s[i])-ord('0') in integers:
                curnum=curnum*10+int(s[i])
                
            elif s[i]=="[":
                str1.append(curstr)
                num.append(curnum)
                curstr=""
                curnum=0
                
            elif s[i]=="]":
                curnum=num.pop()
                temp=curstr
                curstr=""
                while curnum>0:
                    curstr=curstr+temp
                    curnum-=1
                curstr=str1.pop()+curstr
                    
            else:
                curstr=curstr+s[i]
               
        
        return curstr


        