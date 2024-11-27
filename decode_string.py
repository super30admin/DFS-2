# This problem is solved using a stack to keep track of characters and numbers. 
# When encountering an open bracket '[', push the current string and count to the stack, then reset them for decoding the substring inside the brackets. 
# When encountering a closing bracket ']', pop the previous string and count, repeat the current decoded substring 'count' times, and append it back to the previous string.

# Time Complexity : O(n), where n is the length of the string, as each character is processed once.
# Space Complexity : O(n), due to the stack used to store intermediate results.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []  # Stack to store strings and counts
        current_string = ""  # Current substring being decoded
        current_num = 0  # Current multiplier (k)

        for char in s:
            if char.isdigit():
                # Build the number for multiplier
                current_num = current_num * 10 + int(char)
            elif char == '[':
                # Push the current string and multiplier onto the stack
                stack.append((current_string, current_num))
                # Reset current string and multiplier
                current_string = ""
                current_num = 0
            elif char == ']':
                # Pop the last string and multiplier
                last_string, multiplier = stack.pop()
                # Decode the substring and append to the last string
                current_string = last_string + current_string * multiplier
            else:
                # Append character to the current string
                current_string += char

        return current_string
