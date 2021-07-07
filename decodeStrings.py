# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Too many conditions and data structures

class Solution:
    def decodeString(self, s: str) -> str:
        numStack, charStack = [], []
        num = 0
        result, temp = '', ''
        for c in s:
            if c.isdigit():
                # since we are iterating character by character, we have to the number by multiplying number by 10 and adding current integer.
                num = num * 10 + int(c)
            elif c == '[':
                # Append in the num stack and char stack for nested strings
                numStack.append(num)
                num = 0
                charStack.append(temp)
                temp = ''
            elif c.isalpha():
                # Concating the string
                temp += c
            else:
                # Pop and get the number of repitations and update temp
                rep = numStack.pop()
                temp = temp * rep
                temp = charStack.pop() + temp
            if not numStack:
                # If not nested, add temp to result
                result += temp
                temp = ''

        return result