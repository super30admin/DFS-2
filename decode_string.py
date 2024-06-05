# Time Complexity : len of output
# Space Complexity : till no. of opening brackets
class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        str_stack = []
        curr_str = []
        num = 0
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':
                num_stack.append(num)
                str_stack.append(curr_str)
                curr_str = []
                num = 0
            elif c == ']':
                pop_val = num_stack.pop()
                temp = curr_str * pop_val
                curr_str = str_stack.pop() + temp
            else:
                curr_str.append(c)
        return ''.join(curr_str)


        