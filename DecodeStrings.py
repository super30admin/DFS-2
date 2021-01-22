'''
    Time Complexity:
        O(mn) (where n = length of the given string, m = max number in the string)

    Space Complexity:
        O(n) (where n = length of the given string)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        2 stack approach.
        One stack to keep track of numbers.
        Another stack to keep track of strings.
'''
class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        str_stack = []
        curr_num = 0
        curr_str = ''

        for c in s:
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            elif c == '[':
                num_stack.append(curr_num)
                curr_num = 0
                str_stack.append(curr_str)
                curr_str = ''
            elif c == ']':
                count = num_stack.pop()
                pre_str = str_stack.pop()
                curr_str = pre_str + curr_str * count
            else:
                curr_str += c

        return curr_str
