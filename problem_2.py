# Time Complexity : O(n) --> length of the output string
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# iterative
class Solution:
    def decodeString(self, s: str) -> str:
        curr_str = ""
        curr_number = 0
        number_stack = []
        string_stack = []
        for i in s:
            if i.isnumeric():
                curr_number = curr_number*10 + int(i)
            elif i.isalpha():
                curr_str = curr_str + i
            elif i == '[':
                string_stack.append(curr_str)
                number_stack.append(curr_number)
                curr_str = ""
                curr_number = 0
            elif i == ']':
                curr_str = string_stack.pop() + (number_stack.pop()*curr_str)
        return curr_str


print(Solution().decodeString('2[abc]3[cd]'))


# Recursive
# class Solution:
#     def helper(self, s):
#         num = 0
#         curr_str = ''
#         while self.index < len(s):
#             if s[self.index].isnumeric():
#                 num = num*10 + int(s[self.index])
#                 self.index += 1
#             elif s[self.index].isalpha():
#                 curr_str += s[self.index]
#                 self.index += 1
#             elif s[self.index] == '[':
#                 self.index += 1
#                 next = self.helper(s)
#                 curr_str += next * num
#                 num = 0
#             elif s[self.index] == ']':
#                 self.index += 1
#                 return curr_str
#         return curr_str
#
#     def decodeString(self, s: str) -> str:
#         self.index = 0
#         return self.helper(s)
#
#
# print(Solution().decodeString('2[abc]3[cd]'))
