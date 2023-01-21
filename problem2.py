#time O(n)
#space O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for c in s:
            stack.append(c)
            if c == "]":
                stack.pop()                 
                strBuffer = ""
                while stack[-1] != "[":
                    strBuffer = stack.pop() + strBuffer
                stack.pop()               
                mult = ""
                while stack and stack[-1].isdigit():
                    mult = stack.pop() + mult
                stack.append(strBuffer * int(mult)) 
        return "".join(stack)   