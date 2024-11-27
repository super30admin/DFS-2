# The decodeString method decodes an encoded string where patterns like "3[a2[c]]" are expanded as per given rules.

# Step 1: Initialization
#   - Use a stack to store previous strings and numbers during nested decoding.
#   - Initialize 'curNum' to build numbers and 'curString' to build the current decoded string.

# Step 2: Iteration
#   - For each character in the string:
#       - '[': Push the current string and number to the stack, then reset them for the next segment.
#       - ']': Pop a number and previous string from the stack, then expand the current string by repeating it and appending it to the previous string.
#       - Digit: Build the number (handles multi-digit numbers by multiplying 'curNum' by 10).
#       - Other: Add characters to 'curString' for decoding.

# Step 3: Return Result
#   - Return the final decoded string stored in 'curString'.

# TC: O(n) - Each character is processed once.
# SC: O(n) - Space for the stack to store intermediate strings and numbers.


class Solution(object):
    def decodeString(self, s):
        stack = []; curNum = 0; curString = ''
        for c in s:
            if c == '[':
                stack.append(curString)
                stack.append(curNum)
                curString = ''
                curNum = 0
            elif c == ']':
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num*curString
            elif c.isdigit():     # curNum*10+int(c) is helpful in keep track of more than 1 digit number
                curNum = curNum*10 + int(c)
            else:
                curString += c
        return curString