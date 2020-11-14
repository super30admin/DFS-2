"""
Time complexity O(N)

Space complexity O(NK)

"""

class Solution_decodestr_ite:
    def decodeString(self, s: str) -> str:
        if(s is None or len(s)==0):
            return s
        currstr=""
        num=0
        numst=[]
        strst=[]
        for ch in s:
            if(ch.isdigit()):
                num=num*10+int(ch)
                
            elif ch =="[":
                numst.append(num)
                strst.append(currstr)
                currstr=""
                num=0
            elif ch =="]":
                times=numst.pop()
                newstr=""
                for i in range(times):
                    newstr+=currstr
                currstr=strst.pop()+newstr
            else:
                currstr+=ch
        return currstr