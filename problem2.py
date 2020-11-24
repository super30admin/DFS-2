#timecomplexity O(kN), k is number of times repeat, N is encoded string
#spacecomplexity O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        if s=="": return ""
        number=0
        num=[]
        current=""
        currstr=[]
        for c in s:
            if c=="[":
                num.append(number)
                currstr.append(current)
                number=0
                current=""
            elif c.isnumeric():

                number=number*10 +int(c) 
             
                current=current
            elif c=="]":
                #pop from num and repeat that time with c
                current = current*num.pop()
                print(current)
                # appending child to parent
                current=currstr.pop()+current       
            else:
                current+=c
                print(current)
        return current