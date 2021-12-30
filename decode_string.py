class Solution(object):
    from collections import deque
    # T.C is O(max number in the string * length of string)
    # S.C is O(length of string)
    #All test cases passed ni leetcode
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None:
            return ""
        num = 0
        curr_str = ''
        num_stack = deque()
        str_stack = deque()
        for char in s:
            if char == '[':
                num_stack.append(num)
                str_stack.append(curr_str)
                num = 0
                curr_str = ''
            elif char == ']':
                num_ret = num_stack.pop()
                str_form = num_ret * curr_str
                str_ret = str_stack.pop()
                curr_str = str_ret + str_form
            elif char.isdigit():

                num = num * 10 + (ord(char) - ord('0'))
                # print(num)
            else:
                # print("before add:", curr_str)
                curr_str += char
                # print("after add:", curr_str)
        return curr_str


class Solution(object):
    from collections import deque
    i = 0

    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """

        if s is None:
            return ""

        num = 0
        curr_str = ''

        while self.i < len(s):

            if s[self.i] == '[':
                self.i += 1
                print("num before decode call:", num)
                ret_str = self.decodeString(s)
                print("num after decode call:", num)
                frm_str = num * ret_str
                curr_str += frm_str
                print("curr_str in if block call", curr_str)
                num = 0
                print("num after decode call make 0:", num)

            elif s[self.i] == ']':
                self.i += 1
                print("num while returning to call", num)
                print("curr_str in ] block", curr_str)
                return curr_str

            elif s[self.i].isdigit():
                print("num in digi block before call", num)
                num = num * 10 + (ord(s[self.i]) - ord('0'))
                print("num in digi block after call", num)
                self.i += 1

            else:
                print("curr_str in else block before call", curr_str, num)
                curr_str += s[self.i]
                print("curr_str in else block before call", curr_str, num)
                self.i += 1

        return curr_str