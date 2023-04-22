# Time Complexity: O(maxK*n) where m is the number of times the string is repeated and n is the length of the string
# Space Complexity: O(n) where n is the number of recursive calls
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We create the string by appending the characters to the current string. If we encounter a number, 
we multiply the number by 10 and add the current number to it. If we encounter a '[' we call the 
recursive function to decode the string. If we encounter a ']' we return the current string. 
We keep track of the index of the string and increment it as we traverse through the string.
"""

class Solution:
    index = 0
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0: return ""

        number = 0
        curr_str = []
        while self.index < len(s):
            char = s[self.index]
            if char >= '0' and char <= '9':
                number = number * 10 + int(char)
                self.index += 1

            elif char == '[':
                self.index += 1
                decoded = self.decodeString(s)
                for _ in range(number):
                    curr_str = curr_str + decoded
                number = 0

            elif char == ']':
                self.index += 1
                return curr_str

            else:
                curr_str += char
                self.index += 1

        return "".join(curr_str)