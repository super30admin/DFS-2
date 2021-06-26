class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        num = 0
        current_s = ''
        
        for c in s:
            if c == '[':
                stack.append(current_s)
                stack.append(num)
                current_s = ''
                num = 0
            elif c == ']':
                diff = stack.pop()
                prev = stack.pop()
                
                current_s = prev + diff*current_s
            elif c.isdigit():
                num = num * 10 + int(c)
            else:
                current_s += c
        return current_s