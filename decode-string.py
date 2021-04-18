# Time Complexity : O(n*k), where n is the length of the string and k is the largest number in the string
# Space Complexity : O(n*k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return s

        str_stack = list()
        num_stack = list()

        num = 0
        curr = list()

        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)

            elif char == "[":
                str_stack.append(curr)
                curr = list()

                num_stack.append(num)
                num = 0

            elif char == "]":
                num = num_stack.pop(-1)

                curr = curr * num
                num = 0

                curr = str_stack.pop(-1) + curr

            else:
                curr.append(char)

        return "".join(curr)