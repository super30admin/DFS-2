# APPROACH  
# Time Complexity :O(nk), n: len(str), k: max int in encoded str
# Space Complexity : O(n^2*k), (for second elif: new str is created each time a char is added to it at end., in last elif repeating the curr_str k times)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. go through each char of s. have a current number, string and a stack for number amd string.
# 2. if an alphabet, append to end of current string, if a number, modify the current number to include in one's place
# 3. if a '[', push the current variables in respective stack and reset to initial values.
# 4. If a ']', pop th number stack and that number indicates the repititiion for the current string. Then add this repeated string to the string popped from string stack. 


class Solution:
    def decodeString(self, s: str) -> str:
        
        if s is None:
            return None
        
        num, curr_str, num_stack, str_stack = 0, "", [], []
        
        for char in s:
            
            if ord(char) >= ord('0') and ord(char) <= ord("9"):
                num = num * 10 + int(char)
                
            elif (ord(char) >= ord('a') and ord(char) <= ord("z")) or (ord(char) >= ord('A') and ord(char) <= ord("Z")):
                curr_str = curr_str + char
                
            elif char == '[':
                num_stack.append(num)
                num = 0
                str_stack.append(curr_str)
                curr_str = ""
                
            elif char == ']':
                count = num_stack.pop()
                new_str = ""
                while count > 0:
                    new_str = new_str + curr_str
                    count -= 1
                curr_str = str_stack.pop() + new_str
                
        return curr_str
                
