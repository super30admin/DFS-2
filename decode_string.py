
#TC: O(n), n is length of string
#SP: O(n) to form the output string
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        curr_sum = 0
        curr_str = ""
        for i in s:
            if i == '[':
                stack.append(curr_sum)
                stack.append(curr_str)
                curr_sum = 0
                curr_str = ""
            elif i == ']':
                old_str = stack.pop()
                rep = stack.pop()

                curr_str = old_str + rep*curr_str
            elif i.isdigit():
                curr_sum = 10* curr_sum + int(i)
            else:
                curr_str+=i
        return curr_str