# O(N) TIME AND O(1) SPACE WHERE N IS LEN(S)
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for char in s:
            if char == "]":
                current_chars = []
                while stack and stack[-1] != "[":
                    current_chars.append(stack.pop())
                    
                stack.pop()
                current_num = 0
                base = 1
                
                while stack and stack[-1].isdigit():
                    digit = int(stack.pop())
                    current_num += digit * base
                    base *= 10

                while current_num != 0:
                    for i in reversed(range(len(current_chars))):
                        char = current_chars[i]
                        stack.append(char)
                    current_num -= 1             
            else:
                stack.append(char)
        
        return ''.join(stack)