# Time complexity: O(N * max(D)) where D is the digit 
# Space complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def decodeString(self, s: str) -> str:
		# Base case
        if not s or len(s) == 0:
            return s
       
		# Taking two stack one for number and one for string
        num = 0
        current_str = ''
        num_stack = []
        string_stack = []
        
		# Iterate through given string there are 4 possible 
		# 1. Digit
		# 2. Opening Bracket
		# 3. Closing Bracket
		# 4. Alphabet
		
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)  # for ex: if we have a31[bc] 
			# Append to two stacks and reset num = 0 and current_str = ''
            elif c == '[':
                string_stack.append(current_str)
                num_stack.append(num)
                num = 0
                current_str = '' 
           # Pop from stack and add them 
		   # mutiple with current_ str to get decoding string
            elif c == ']':
                prev_num_instack = num_stack.pop()
                prev_str_instack = string_stack.pop()
                current_str = prev_str_instack + prev_num_instack * current_str 
           
		   # found a character in 's' then append to current_str
            else:
                current_str += c 
		
		# return current_str
        return current_str
