'''
Time Complexity - O(n) where n is length of String
Space Complexity - O(m+n) where m is length of parent and n is length of nums
'''


class Solution:
    def decodeString(self, s: str) -> str:
        curr = ""
        currNum = 0
        num = []
        parent = []

        for char in s:
            if char.isdigit():
                currNum = int(currNum * 10 + int(char))
            elif char == '[':
                num.append(currNum)
                parent.append(curr)
                curr = ""
                currNum = 0
            elif char == ']':
                curr *= num.pop()
                curr = parent.pop() + curr
            else:
                curr += char
        return curr
