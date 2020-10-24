# O(maxK * N) TIME AND SPACE where maxK is max number in string and N is length of string
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for char in s:
            if char == ']':
                current_chars = []
                while stack and stack[-1] != "[":
                    current_chars.append(stack.pop())
                stack.pop()
                number = 0
                base = 1
                while stack and stack[-1].isdigit():
                    digit = int(stack.pop())
                    number += digit * base
                    base *= 10
                
                while number != 0 :
                    for i in reversed(range(len(current_chars))):
                        char = current_chars[i]
                        stack.append(char)
                    number -= 1
                    
            else:
                stack.append(char)
        return ''.join((stack))

