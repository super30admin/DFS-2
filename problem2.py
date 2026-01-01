"""
We use stacks and states to main the prev and curr states of the string, for if a ch is a number, we add it as current number and store it for operationss if we see a closing bracket
to use it as a multiplier. if we see a opening bracket, we append the current string and number to the stack and reset their values so as we not overflow it into next bracket
operation. if we see a ], we pop prev values from the stack and build the new current string.
TC and SC is o(n + m) where n is len of input and m is len of output and the time and stack space is dependent heavily on ouput as well
"""

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stck = []
        currString = ""
        currNum = 0
        
        for ch in s:
            if ch.isdigit():
                currNum = currNum * 10 + int(ch)

            elif ch == '[':
                #append curr string and curr num
                stck.append((currString, currNum))
                #reset curr string and curr num
                currString = ""
                currNum = 0
            elif ch == ']':
                #pop latest values from stack as prev string and count multiplier
                prevString, prevNum = stck.pop()
                #build new string using prev and multiplier times curr string
                currString = prevString + prevNum * currString 
            else: #its a character, just add to curr string
                currString += ch 
        return currString
        