# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for char in s:
            if char == ']':
                decoded_string = []
                # Get the encoded string
                while stack[-1] != '[':
                    decoded_string.append(stack.pop())
                # Pop '[' from the stack
                stack.pop()
                base = 1
                k = 0
                # Get the number k
                while stack and stack[-1].isdigit():
                    k = k + int(stack.pop()) * base
                    base *= 10
                # Decode k[decoded_string], by pushing decoded_string k times into stack
                while k != 0:
                    for j in range(len(decoded_string) - 1, -1, -1):
                        stack.append(decoded_string[j])
                    k -= 1
            # Push the current character to the stack
            else:
                stack.append(char)
                
        # Get the result from the stack
        result = ''
        while stack:
            result = stack.pop() + result
        return result