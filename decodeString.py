#Time Complexity : O(n*m) where n in the number of characters in the string and m is the number of temp strings or characters.
#Space Complexity :  O(n) where n in the number of characters in the string

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Iterate through the string, and according to variosu conditions on basis of what kind of character we encounter we need to perform different actions.

class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        result = ""
        stack = []
        num = 0

        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            elif char == "[":
                stack.append(num)
                num = 0
            elif char.isalpha():
                stack.append(char)
            else:
                temp = ""
                while str(stack[-1]).isalpha():
                    temp += stack.pop()
                stack.append(temp*stack.pop())

        while stack:
            result += stack.pop()

        return result[::-1]
