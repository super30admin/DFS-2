#TimeComplexity: - O(kn) where is maximum value of k of append operation done
#Space Complexity:- O(n) depends on the depth which is brackets that are present we can say the number of nesting present 

class Solution:
    def decodeString(self, s: str) -> str:
        strStack = []
        numStack = []
        num =0
        currStr = ''
        for i in range(len(s)):
            c = s[i]
            if(c.isdigit()):
                num = num * 10 + (ord(c) - ord('0'))
            elif(c =='['):
                numStack.append(num)
                strStack.append(currStr)
                num = 0
                currStr = '' 
            elif(c==']'):
                times = numStack.pop()
                newString = times*currStr
                currStr = strStack.pop() + newString
            else:
                currStr = currStr+c
        return currStr


## Recursive appraoch 

class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        num =0
        currStr = ''
        while(self.i<len(s)):
            c = s[self.i]
            if(c.isdigit()):
                num = num * 10 + (ord(c) - ord('0'))
                self.i+=1
            elif(c =='['):
                self.i+=1
                decoded = self.decodeString(s)
                newString = num*decoded
                currStr = currStr+ newString
                num = 0
            elif(c==']'):
                self.i+=1
                return currStr
            else:
                currStr = currStr+c
                self.i+=1
        return currStr


        


        