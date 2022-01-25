# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import Deque


class Solution:
    def decodeString(self, s: str) -> str:
        num = 0
        char = ""
        nums = Deque()
        strs = Deque()

        for i in s:
            if i.isnumeric():
                num = num * 10 + int(i)

            # when a open bracket is encountered
            elif i == "[":
                nums.append(num)
                strs.append(char)
                num = 0
                char = ""

            # when a closed bracket is encountered
            elif i == "]":
                rep = nums.pop()
                new_char = ""

                for x in range(rep):
                    new_char = new_char + char

                char = strs.pop()
                char = char + new_char

            else:
                char = char + i

        return char
