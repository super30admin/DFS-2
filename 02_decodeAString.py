# https://leetcode.com/problems/decode-string
# // Time Complexity : O(pxl), p is product and l is length of string
# // Space Complexity : O(pxl) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:

        stack = []

        for ch in s:
            if ch != ']':
                stack.append(ch)
            else:
                substr = ""
                while (stack[-1] != '['):
                    substr = stack.pop() + substr #add the poped element to the begining of the string
                stack.pop() #pop the opening bracket

                k = ""
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k #add the digit to the begining if more than 1 digits

                stack.append(int(k) * substr)
        
        return "".join(stack)

