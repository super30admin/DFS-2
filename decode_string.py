# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        str_stack = []
        curr_str = ""
        curr_num = 0
        
        for c in s:
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            elif c == '[':
                str_stack.append(curr_str)
                curr_str = ""
                num_stack.append(curr_num)
                curr_num = 0
            elif c == ']':
                temp_str = curr_str
                curr_str = str_stack.pop()
                count = num_stack.pop()
                curr_str += temp_str * count
            else:
                curr_str += c
        
        return curr_str
