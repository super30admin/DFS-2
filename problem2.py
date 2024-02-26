# Time Complexity : O(K x N) where K is largest integer in the string and N is the length of string
# Space Complexity : O(N) where N is the lenth of the string.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, one issue is with data type of int and string.


# Your code here along with comments explaining your approach
# Approach : We will use a single stack and store all the string so far we have encountered into it.
# Once we have a closing bracket, we will pop all the elements and process the string between it.
# basically, repeat the string by the integer we found. and again push back to the stack. and keep
# repeating the process. At the end remove all the values from stack and append them and return it.

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        index = 0
        number = 0
        while index < len(s):
            cur_element = s[index]

            if cur_element.isdigit():
                number = number * 10 + int(cur_element)

            elif cur_element == '[':
                if number != 0:
                    stack.append(number)
                    number = 0
                stack.append(cur_element)

            elif cur_element.isalpha():
                stack.append(cur_element)

            elif cur_element == ']':
                # Process string
                # Pop element till '['
                cur_str = ''
                multiplier = 0
                while stack[-1] != '[':
                    cur_str = stack.pop() + cur_str
                stack.pop()
                if type(stack[-1]) is int:
                    multiplier = stack.pop()
                stack.append(cur_str * multiplier)
            index += 1

        size = len(stack)
        result = ''
        for i in range(size):
            result = stack.pop() + result
        return result
