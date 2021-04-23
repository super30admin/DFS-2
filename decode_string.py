class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return s
        char_stack = []
        num_stack = []
        curr_string = ""
        num = 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + (int(c))
            elif c == "[":
                num_stack.append(num)
                char_stack.append(curr_string)
                num = 0
                curr_string = ""
            elif c == "]":
                times = num_stack.pop()
                res = ""
                for i in range(times):
                    res += curr_string
                curr_string = char_stack.pop() + res
            else:
                curr_string += c
        return curr_string
