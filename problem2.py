'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create the stack and add elements or remove based on the following rules:
if '[' do recursion, if ']' resolved return/pop, char : append it to result.
'''

class Solution:
    def __init__(self):
        self.cursor = 0

    def decodeString(self, s: str) -> str:
        # parse the string

        res = ''

        k = 0

        while self.cursor < len(s):
            token = s[self.cursor]

            # if token is digit
            if token >= '0' and token <= '9':
                self.cursor += 1
                # Convert string integer to integer
                k = k * 10 + int(token)
            elif token == '[':
                # if [ recurse, then multiply
                self.cursor += 1
                nextRes = self.decodeString(s)

                while k > 0:
                    res = res + nextRes
                    k -= 1
            elif token == ']':
                # if  ] return
                self.cursor += 1
                return res
            else:
                # append
                self.cursor += 1
                res = res + token

        return res