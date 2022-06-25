#Time complexity: O(lengthofOutput)
#Space complexity: O(no.of open braces)

class Solution:
    def decodeString(self, s: str) -> str:
        currStr = ""
        num = 0
        strSt = deque()
        numSt = deque()
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + (ord(c)-ord('0'))
            elif c == "[":
                strSt.append(currStr)
                numSt.append(num)
                currStr = ""
                num = 0
            elif c == "]":
                k = numSt.pop()
                temp = ""
                for p in range(k):
                    temp += currStr
                parent = strSt.pop()
                currStr = parent + temp
            else:
                currStr += c
            
        return currStr
                
           
                
                
            
            
                
