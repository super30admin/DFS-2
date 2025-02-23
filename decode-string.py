# Time O(max(n, k)) k = largest int in s
# Space O(n) n = output string
class Solution:
    def decodeString(self, s: str) -> str:
        str_stack = []
        num_stack = []
        curr_num = 0
        curr_str = []
        for c in s:
            if c.isdigit():
                curr_num = (curr_num * 10) + ord(c) - ord('0')
            elif c == "[":
                str_stack.append("".join(curr_str))
                curr_str = []
                num_stack.append(curr_num)
                curr_num = 0
            elif c == "]":
                num = num_stack.pop()
                new_str = [str_stack.pop()]
                curr_str_val = "".join(curr_str)
                for i in range(num):
                    new_str.append(curr_str_val)
                curr_str = ["".join(new_str)]
            else: curr_str.append(c)
        return "".join(curr_str) 
            


        