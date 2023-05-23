#TC: O(n)
#SC: O(n)

class Solution:
    def decodeString(self, s: str) -> str:

        currStr = ''
        currNum = 0
        stack = []
        cursor = 0
        digits = '0123456789'

        while (cursor < len(s)):

            if (s[cursor] in digits):                    
                currNum = (currNum * 10) + int(s[cursor])

            elif (s[cursor] == '['):              
                stack.append([currStr, currNum])  
                currStr = ''
                currNum = 0

            elif (s[cursor] == ']'):                        
                                                            
                topElement = stack.pop()
                prevStr = topElement[0]
                prevNum = topElement[1]
                currStr = prevStr + (currStr * prevNum)

            else: 
                currStr += s[cursor]                

            cursor += 1

        return currStr                                      


class DecodeString_Recursion:

    def __init__(self):
        self.cursor = 0
        self.digits = '0123456789'

    def decodeString(self, s: str) -> str:

        result = ''
        times = 0

        while (self.cursor < len(s)):

            token = s[self.cursor]

            if (token in self.digits):
                self.cursor += 1 
                times = (times * 10) + int(token)

            elif (token == '['):
                self.cursor += 1
                innerResult = self.decodeString(s)
                result = result + (innerResult * times)   
                times = 0

            elif (token == ']'):
                self.cursor += 1
                return result

            else:             
                self.cursor += 1
                result += token

        return result                                  