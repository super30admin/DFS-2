class Solution:
    def decodeString(self, s: str) -> str:
        if not s or len(s) == 0: return s
        strStack = []
        numStack =[]
        num = 0
        currStr = ""
        for i in range(len(s)):
            #case 1: character is a digit
            if s[i].isdigit():
                num = num*10 + int(s[i])
            #case 2: character is a "["
            elif s[i] == '[':
                numStack.append(num)
                strStack.append(currStr)
                num = 0
                currStr = ''
            #case 3: character is a "]"
            elif s[i] == "]":
                newStr = numStack.pop() * currStr
                currStr = strStack.pop() + newStr
            #case 4: just a character
            else:
                currStr += s[i]
        
        return currStr
    
#Time complexity is the product of max value of multiplier along with the length of decoded string
#Space complexity is the O(h) where h is the max depth of the string