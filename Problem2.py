## Problem2 (https://leetcode.com/problems/decode-string/)

#Approach - 1
class Solution:
    def decodeString(self, s: str) -> str:
        # Using single Stack, appending one char at a time and poping when "]" occurs. 
        #TC: O(N)
        #SC: O(N)
        if s == "" or (len(s) == 1 and s.isdigit()) : return ""
        stack = []
        for c in s:
            if c == ']':
                st = ""
                while stack[-1] != '[':
                    st = stack.pop() + st
                stack.pop()
                num = ''
                
                while stack and stack[-1].isdigit():
                    num = stack.pop() + num
                stack.append(int(num) * st)

            else:
                stack.append(c)

        return "".join(stack)

# Approach - 2

class Solution:
    def decodeString(self, s: str) -> str:
        """
        Using 2 stacks, one to store digits and second to store char
        TC: O(N)
        SC: O(N)
        """
        numStack = []
        charStack = []
        currNum, currChar = "", ""

        for c in s:
            if c.isdigit():
                currNum += c
            elif c == '[':
                numStack.append(currNum)
                charStack.append(currChar)
                currChar = ""
                currNum = ""
            elif c == ']':
                currChar = "".join(currChar * int(numStack.pop()))
                currChar = "".join(charStack.pop() + currChar)
            else:
                currChar += c

        return currChar


