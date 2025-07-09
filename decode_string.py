# Time Complexity : O(n), where n is the length of the input string
# Space Complexity : O(n), for the stack used to handle nested structures
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a stack to keep track of characters, numbers, and previously decoded strings.
# When I encountered a ']', I popped from the stack until I hit the matching '['.
# I then repeated the extracted substring by the repeat count and pushed it back onto the stack.
# At the end, I joined everything in the stack to get the final result.

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        curr_num = 0
        curr_str = ""

        for char in s:
            if char.isdigit():
                curr_num = curr_num * 10 + int(char)
            elif char == '[':
                stack.append((curr_str, curr_num))
                curr_str = ""
                curr_num = 0
            elif char == ']':
                prev_str, num = stack.pop()
                curr_str = prev_str + num * curr_str
            else:
                curr_str += char

        return curr_str
