class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for ch in s:
            if ch != ']':
                stack.append(ch)
                temp = ''
                multiply = ''
                while stack[-1] != '[':
                    temp = stack.pop() + temp
                
                stack.pop()
                
                while stack and stack[-1].isdigit():
                    multiply = stack.pop() + multiply

                stack.append(temp * int(multiply))

        return ''.join(stack)