# Time Complexity : O(k*n), where n is the length of the input string s, and k is the maximum number of times a substring can be repeated.
# Space Complexity : O(k*n), where n is the length of the input string s, and k is the maximum number of times a substring can be repeated.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We will use 2 stacks to store the 1)numbers and 2)strings.
# If we encounter a digit, we will update the current number.
# If we encounter an alphabet, we will update the current string.
# If we encounter a '[', it means that we have reached a nested string, and so we will need to decode that first.
# We will preserve the state of the parent string and the number associated with it in the stacks.
# If we encounter a ']', it means that we have reached the end of a nested string, and now we need to decode it.
# We will pop the number and repeat the current string that many times.
# Finally, we will return the decoded string.

class Solution:
    def decodeString(self, s: str) -> str:
        # Initialize two stacks to store the numbers and strings
        numSt, strSt = [], []
        # Initialize variables to keep track of the current number and string
        currNum, currStr = 0, ""

        # Iterate through the input string
        for c in s:
            # If the character is a digit, update the current number
            if c.isdigit():
                currNum = currNum*10 + ord(c) - ord('0')
            # If the character is a '[', it means we have reached a nested string and need to preserve the state of tehe parent string and number
            # We will push the current number and string onto the stacks
            # Then we will reset the current number and string
            elif c == "[":
                numSt.append(currNum)
                strSt.append(currStr)
                currNum = 0
                currStr = ""
            # If the character is a ']', it means we have reached the end of a nested string and need to decode it
            # We will pop the number and repeat the current string that many times
            # Then we will concatenate the current string with the string popped from the stack
            elif c == "]":
                num = numSt.pop()
                tmp = currStr * num
                currStr = strSt.pop() + tmp
            # If the character is an alphabet, we will update the current string
            else:
                currStr += c

        # Finally, we will return the decoded string
        return currStr