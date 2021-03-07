# TC: O(n * maxk)
# SC: O(n)
# LeetCode: Y(https://leetcode.com/problems/decode-string/)
# Approach: Use two stack to push numbers and current string
#           Decode only when ] is seen
#           Continue building the number till [ is seen
#           [ => push number and current string
#           character -> append to current string
class Solution:
    def decodeString(self, s: str) -> str:
        
        # base case
        if ((not s) or (len(s) == 0)):
            return s
        
        # track current string
        currentString = ""
        
        # numbersStack
        numStack = []
        
        # stringsStack
        stringStack = []
        
        # num
        num = 0
        
        # lopp through the string
        for c in s:
            
            # if current character is digit then continue building num
            if c.isdigit():
                num = num * 10 + int(c)
            
            # if '[' => push num, current string and reset them
            elif c == '[':
                numStack.append(num)
                stringStack.append(currentString)
                num = 0
                currentString = ""
            
            # if ']' => start decoding
            elif c == ']':
                # get the number to multiply with current string
                multiplier = numStack.pop()
                
                # concatenate the current string with itself multiplier times
                newString = currentString * multiplier
                
                # append the newly built string to previously built string and store it as current string 
                currentString = stringStack.pop() + newString
            
            # append current character to current string
            else:
                currentString += c
          
        # return the computed current string at end
        return currentString
                
                
                
        
