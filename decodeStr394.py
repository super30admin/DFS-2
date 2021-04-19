"""
Approach - Using two stacks
TC -  O(nk)
SC - O(nk)
"""
class Solution:
    def decodeString(self, s: str) -> str:
        if not s or len(s) == 0:
            return s
        
        strstack = []
        numstack = []
        
        currstr = ""
        num = 0
        for c in s:            
            if c.isdigit():
                #print(c, "digit")
                num = 10 * num + ord(c) - 48
                #print(type(num))
            elif c == '[':
                print(c, "left")
                strstack.append(currstr)
                numstack.append(num)
                currstr = ""
                num = 0
                
            elif c == ']':
                print(c, "right")
                n = numstack.pop()
                #print(n)
                currstr = n * currstr
                
                start = strstack.pop()
                currstr = start + currstr
                #print(currstr)
                
            elif c.isalpha():
                print(c, "alpha")
                currstr += c
        
        return currstr
        