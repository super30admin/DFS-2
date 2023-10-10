#TC - O(n)
# SC - O(n) 
class Solution:
    def decodeString(self, s: str) -> str:
        curr_str = ""
        curr_num = 0
        str_stack = []
        num_stack = []

        for char in s:
            if char.isdigit():
                curr_num = curr_num * 10 + int(char)
            elif char == '[':
                num_stack.append(curr_num)
                str_stack.append(curr_str)
                curr_num = 0
                curr_str = ""
            elif char == ']':
                cnt = num_stack.pop()
                baby = curr_str * cnt
                curr_str = str_stack.pop() + baby
            else:
                curr_str += char

        return curr_str