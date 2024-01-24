#Time Complexity : O(N)
#Space Complexity :O(N)
#Did this code successfully run on Leetcode : yes

class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        char_stack = []
        result = ""
        num = 0

        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            elif char == "[":
                num_stack.append(num)
                char_stack.append(result)
                result = ""
                num = 0
            elif char == "]":
                prev_num = num_stack.pop()
                prev_str = char_stack.pop()
                result = prev_str + prev_num * result
            else:
                result += char

        return result