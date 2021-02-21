################# Iterative solution
# Time complexity: O(n)
# Space complexity: O(n)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses 2 stacks- one for storing integers and other for storing strings of characters. We initialize 2 variables
# as curr_str, and curr_int to store the current string and integer value, respectively. We iterate through the string, and whenever a number appears, we update the
# current_int. SImilarly, whenever a character appears, we update the current character. For the opening bracket, we update push the curr_int the integer stack, and
# curr_str in the string stack. When the closing bracket, we pop the integer from the integer stack, and repeat the current characters and add to current string that many times. Then we pop through
# the string stack, and add it to current string. Lastly, return the current string.

class Solution:
    def decodeString(self, s: str) -> str:
        stack_int = []
        stack_string = []

        curr_num = 0
        curr_str = ""
        for char in s:
            if char.isnumeric():
                curr_num = curr_num * 10 + int(char)

            elif char.isalpha():
                curr_str += char

            elif char == '[':
                stack_int.append(curr_num)
                stack_string.append(curr_str)
                curr_num = 0
                curr_str = ""

            elif char == ']':
                nums = stack_int.pop()

                temp_string = ""
                for _ in range(nums):
                    temp_string += curr_str

                top_char = stack_string.pop()
                curr_str = top_char + temp_string

        return curr_str

result = Solution()
print(result.decodeString("3[a]2[bc]"))

