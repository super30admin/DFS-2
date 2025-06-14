# Space Complexity - multiplication of all the digits
# Time Complexity - multiplication of all the digits

class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        str_stack = []
        res = ''
        curr_str = ''
        num = 0
        
        for c in s:
            if c.isdigit():
                num = num*10 + int(c)
            elif c == '[':
                str_stack.append(curr_str)
                num_stack.append(num)
                curr_str = ''
                num = 0
            elif c == ']':
                count = num_stack.pop()
                string = str_stack.pop()
                curr_str = string + curr_str*count
            else:
                curr_str += c

        return curr_str
