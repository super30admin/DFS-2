"""
Time complexity O(N)

"""

class Solution_decodestrR:
 
    def decodeString(self, s: str,i=0) -> str:
        if(s is None or len(s)==0):
            return s
        self.i=0
        return self.decodeStr(s)
        
    def decodeStr(self,s):
        currstr=""
        num=0
        while(self.i<len(s)):
            print(self.i)
            ch=s[self.i]
            if(ch.isdigit()):
                num=num*10+int(ch)
                self.i+=1
            elif ch =="[":
                self.i+=1
                decodestr=self.decodeStr(s)
                newstr=""
                for j in range(num):
                    newstr+=decodestr
                currstr+=newstr
                num=0
            elif ch =="]":
                self.i+=1
                return currstr
            else:
                currstr+=ch
                self.i+=1
        return currstr