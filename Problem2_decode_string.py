class Solution(object):
    def decodeString(self, s):
        """
        Time complexity : O(maxK * n) where n is the length of the string and maxK is the maximum value of k.
        Space complexity : O(m + n) where m is the number of digits in the string
        :type s: str
        :rtype: str
        """
        stack = []

        for i in range(len(s)):
            if s[i] != "]":
                stack.append(s[i])
            else:
                substr = ""
                #top of stack != opening bracket
                while stack[-1] != "[":
                    substr = stack.pop() + substr
                stack.pop()

                k = ""

                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                stack.append(int(k) * substr)
        
        return "".join(stack)