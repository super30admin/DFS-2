##Time Complexity : 0(n)
##Space Complexity : 0(n) 
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        number = 0
        string = ''
        stack = []
        for c in s:
            if c.isdigit():
                number = number*10 + int(c)
            elif c == "[":
                stack.append(string)
                stack.append(number)
                string = ''
                number = 0
            elif c.isalpha():
                string += c
            elif c == ']':
                prev_number = stack.pop()
                prev_string = stack.pop()
                string = prev_string + prev_number * string
        return string
        