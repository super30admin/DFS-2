# Time Complexity : O(n*max(repitition))
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
# It took me 2nd attempt to finish this. I was not able to solve this on the first day after class

# Your code here along with comments explaining your approach
# I iterate through index on string doing different operation based on the 4 kinds of letters we can have
# I collect current number and current string and whenever I find a '[', I form a new subproblem and I return from 
# the subproblem when I encounter ]

# https://leetcode.com/problems/decode-string/
class Solution:
    def decodeString(self, s: str) -> str:
        
        
        def helper():
            current_number = 0
            current_string = ""
            
            while self.i < len(s):
                c = s[self.i]

                if c.isnumeric():
                    current_number = int(current_number) * 10 + int(c)
                    self.i += 1
                elif c.isalpha():
                    current_string += c
                    self.i += 1
                elif c == "[":
                    self.i += 1
                    current_string = current_string + current_number*helper()
                    current_number = 0
                elif c == "]":
                    self.i += 1
                    return current_string
            return current_string
                
        self.i = 0
        result = ""
        while self.i < len(s):
            result += helper()
            
        return result