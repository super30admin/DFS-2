# Time Complexity: O(nk), where n is the length of the string and k - max num in the string
# Space Complexity: O(nk)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def decodeString(self, s: str) -> str:
        if not s or len(s) == 0:
            return ""

        num_stack = []
        str_stack = []
        num = 0
        curr_str = ""

        for ch in s:
            if ch.isdigit():
                num = num * 10 + int(ch)

            elif ch == "[":
                # Push num and curr str to the stacks and reset them
                num_stack.append(num)
                str_stack.append(curr_str)
                num = 0
                curr_str = ""

            elif ch == "]":
                # Repeat curr str n times from num_stack
                n = num_stack.pop()
                curr_str = curr_str * n
                # Append prev str from str_stack
                curr_str = str_stack.pop() + curr_str

            else:
                curr_str = curr_str + ch

        return curr_str

