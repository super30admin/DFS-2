# // Time Complexity : O(Kn) Where K is the length of the string
# // Space Complexity : O(m+n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# Using 2 stacks
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
            return s
        num = 0
        str1 = ""
        num_stack = []
        str_stack = []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':
                num_stack.append(num)
                str_stack.append(str1)
                num = 0
                str1 = ""
            elif c == ']':
                times = num_stack.pop()
                new_str = times * str1
                str1 = str_stack.pop() + new_str
            else:
                str1 += c
        return str1



