# Time Complexity: O(N) when there are no repetitions and O(N * K) when there are repetitions
# (N is the length of the string, K is the Product of Integers in the string)
# Space Complexity: O(N) Auxiliary space and O(N * K) including output space
# Did this code successfully run on Leetcode: Yes

class Solution:
    def decodeString(self, s: str) -> str:
        current_num = 0
        current_string = ""
        num_stack = [0]
        string_stack = [""]

        for char in s:
            if char.isdigit():
                current_num = current_num * 10  + ord(char) - ord("0")
            elif char == "[":
                num_stack.append(current_num)
                current_num = 0
                string_stack.append(current_string)
                current_string = ""
            elif char == "]":
                num = num_stack.pop()
                decoded_string = current_string * num
                string = string_stack.pop()
                current_string = string + decoded_string
            else:
                current_string += char
        
        return current_string
