#Time complexity: O(len of result string)
#Space complexity: O(M+N) where M is unique string, N is number of digits
class Solution: 
    def decodeString(self, s: str) -> str:
        strst=[] #string stack
        numst=[] #number stack
        currstr=""
        currnum=0
        for c in s:
            if c.isdigit():
                currnum=currnum*10+int(c)
            elif c=='[':
                strst.append(currstr)
                numst.append(currnum)
                currstr=""
                currnum=0
                
            elif c==']':
                tempstr=strst.pop()
                tempnum=numst.pop()
                # print("tempstr", tempstr)
                # print(currstr*tempnum)
                currstr=tempstr+currstr*tempnum
            else:
                currstr+=c
        return (currstr)
                