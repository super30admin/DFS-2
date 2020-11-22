"""
Time complexity O(N)

Space complexity O(NK)

"""

class Solution_singlestack:
    def decodeString(self, s: str) -> str:
        if(s is None or len(s)==0):
            return s
        currstr=""
        num=0
        st=[]
        
        for ch in s:
            if(ch.isdigit()):
                num=num*10+int(ch)
                
            elif ch =="[":
                st.append([num,currstr])
                currstr=""
                num=0
            elif ch =="]":
                l=st.pop()
                times=l[0]
                newstr=""
                for i in range(times):
                    newstr+=currstr
                currstr=l[1]+newstr
            else:
                currstr+=ch
        return currstr