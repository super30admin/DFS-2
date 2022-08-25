# Time Complexity : O(N) Number of characters in string
#  Space Complexity : O(N) Space taken by stack
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def decodeString(self, s: str) -> str:
        
        #Declare stack to add string and numbers
        stack = []
        num = 0
        string = ''
        
        #Iterate over the string and separate out the string and number based on "[" brackets
        for char in s:
            #Push when the '[' is detected and pop when ']' is detected else add uup the strings and return
            if char == '[':
                stack.append(string)
                stack.append(num)
                
                string = ''
                num = 0
            elif char ==']':
                prevNum = stack.pop()
                prevString = stack.pop()
                string = prevString + prevNum*string
            elif char.isdigit():
                num = num * 10 + int(char)
            else:
                string +=char
        return string