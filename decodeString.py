class Solution:
# Time Complexity : O(L) where L is the length of the output string
# Space Complexity : O(L) where L is the length of the output string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    def decodeString(self, s: str) -> str:
        num_stack = []
        str_stack = []
        curr_string = ""
        curr_num = 0 

        for char in s:
            if char.isdigit(): # digit
                curr_num = curr_num*10 + int(char)
            elif char == "[": # open
                num_stack.append(curr_num)
                str_stack.append(curr_string)
                curr_num = 0
                curr_string = ""
            elif char == "]": # close
                number = num_stack.pop()
                curr_string = str_stack.pop() + (curr_string * number)
                
            else: # is alphabet
                curr_string += char
        
        return curr_string
    
class RecursionSolution:
# Time Complexity : O(L) where L is the length of the output string
# Space Complexity : O(L) where L is the length of the output string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    def __init__(self):
        self.idx = 0

    def decodeString(self, s: str) -> str:

        curr_string = ""
        curr_num = 0 

        while self.idx < len(s):
            char = s[self.idx]
            self.idx += 1
            if char.isdigit(): # digit
                curr_num = curr_num*10 + int(char)
            elif char == "[": # open
                baby = self.decodeString(s) * curr_num
                curr_string += baby
                curr_num = 0
            elif char == "]": # close
                return curr_string
            else: # is alphabet
                curr_string += char

        
        return curr_string