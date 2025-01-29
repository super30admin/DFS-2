# TC and SC -  O(n) and O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        current_string = ""
        current_num = 0

        for char in s:
            print(stack)
            if char.isdigit():
                # Build the current number (multi-digit numbers)
                current_num = current_num * 10 + int(char)
            elif char == '[':
                # Push the current state onto the stack
                stack.append((current_string, current_num))
                # Reset for the new context
                current_string = ""
                current_num = 0
            elif char == ']':
                # Pop the previous state and combine
                prev_string, num = stack.pop()
                current_string = prev_string + current_string * num
            else:
                # Regular characters
                current_string += char
        
        return current_string

