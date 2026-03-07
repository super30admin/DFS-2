# problem 2

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for char_val in s:
            if char_val != ']':
                stack.append(char_val)
            else:
                char_str = ""
                while stack and stack[-1]!='[':
                    char_str = stack.pop() + char_str
                stack.pop()
                num_str = ""
                while stack and stack[-1].isdigit():
                    num_str = stack.pop() + num_str
                curr_string = char_str * int(num_str)
                stack.append(curr_string)
        return "".join(stack)