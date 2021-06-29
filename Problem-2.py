from collections import deque
class Solution:
    # Approach : DFS - iterative
    """
    TC: O(kn) where k is the max digit in the given string
    SC: O(kn)
    """

    def decodeString(self, s: str) -> str:
        """num = 0
        stack_nums = deque()
        stack_str = deque()
        curr_str = []
        for i, char  in enumerate(s):
            if char.isdigit():
                num = num * 10 + ord(char) - ord('0')

            elif char == '[':
                stack_nums.append(num)
                stack_str.append(curr_str)
                num = 0
                curr_str = []

            elif char == ']':
                times = stack_nums.pop()
                replicated = []
                for _ in range(times):
                    replicated += curr_str
                parent = stack_str.pop()
                curr_str = parent + (replicated)
            else:
                curr_str.append(char)

        return ''.join(curr_str)"""

    # Approach : DFS - recursive
    """
    TC: O(kn) where k is the max digit in the given string
    SC: O(kn)
    """

    def __init__(self):
        self.i = 0

    def decodeString(self, s: str) -> str:
        n = len(s)
        num = 0
        curr_str = []
        while self.i < n:
            char = s[self.i]
            if char.isdigit():
                num = num * 10 + ord(char) - ord('0')
                self.i += 1
            elif char == '[':
                self.i += 1
                child = self.decodeString(s)
                new_str = []
                for _ in range(num):
                    new_str += child
                curr_str += new_str
                num = 0

            elif char == ']':
                self.i += 1
                return ''.join(curr_str)
            else:
                self.i += 1
                curr_str.append(char)

        return ''.join(curr_str)