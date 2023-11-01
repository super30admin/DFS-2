'''
1. If the character is a number we keep on multiplying it by 10 and adding the next number to it
2. If we encounter a '[' we call the decodeString function recursively and compute the string inside the brackets
3. If we encounter a ']' we return the string
4. If we encounter a character we append it to the current string

TC: O(n)
SC: O(n) - recursive stack
'''
class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
            return ""
        
        curStr = []
        num = 0
        
        while self.i < len(s):
            c = s[self.i]
            if c >= '0' and c <= '9':
                self.i += 1
                num = num*10 + int(c)

            elif c == '[':
                self.i += 1
                decoded = self.decodeString(s)
                newStr = []
                for j in range(num):
                    newStr.append("".join(decoded))
                curStr.append("".join(newStr))
                num = 0

            elif c == ']':
                self.i+=1
                return "".join(curStr)
            else:
                self.i+=1
                curStr.append(c)
        
        return "".join(curStr)     