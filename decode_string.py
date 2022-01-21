# Did this code successfully run on Leetcode : YES

# TC: O(kN) where k is the maximum number encountered
# SC: O(num_nested)

# iterative using two stacks
# maintain two stacks for multiplier and curr decoded
# when encounter closing, pop and combine with parent

class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        str_stack = []
        # curr multiplier
        num = 0
        # curr string
        curr = ''
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num*10 + int(c)
            elif c == '[':
                # push num and curr into resp. stacks
                str_stack.append(curr)
                num_stack.append(num)
                # reset
                curr = ''
                num = 0
            elif c == ']':
                # decode
                multiplier = num_stack.pop()
                new_str = curr * multiplier
                # combine with parent
                curr = str_stack.pop() + new_str
            else:
                curr += c
        return curr

# Iterative using one stack
# TC: O(kN) where k is the maximum number encountered
# SC: O(num_nested)

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        currstr, mul = '', 0
        for char in s:
            if char == '[':
                # push into stack and reset
                stack.append([currstr, mul])
                currstr, mul = '', 0
            elif char == ']':
                # process
                [tempstr, k] = stack.pop()
                currstr = tempstr + currstr * k
            elif char.isdigit():
                mul = mul * 10 + int(char)
            else:
                currstr += char
        return currstr