#Decode String
# Time complexi ty -> nxk
# Space complexity -> nxk
# Logic-> iterate over the string whenever open bracket is encountered recursively call the method for internal string
# Once closing bracket is encountered return the inner string once it is returned use the output and sum it for num times

class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        resultStrArr = []
        num = 0
        
        while self.i < len(s):
            ch = s[self.i]
            self.i+=1
            
            if ch.isdigit():
                num = num*10 + int(ch)
            elif ch == '[':
                stringTmpRes = self.decodeString(s)
                for k in range(num):
                    resultStrArr.append(stringTmpRes)
                num=0
            elif ch == ']':
                return "".join(resultStrArr)
            else:
                resultStrArr.append(ch)
        return "".join(resultStrArr)