# Leetcode 394. Decode String

# Time Complexity :  O(n) where n is the size of the string

# Space Complexity : O(n) where n is the size of the string

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: iterate through the string with two stacks, and two tracker one each for number and 
# string. If the character is a digit then update the num tracker, if it is a string update the string
# tracker. When open brcket is found append the tracker values to respective stacks and reset them.
# When closing bracket is found, pop the stacks, multiply the string tracker with numStack pop and append
# it to the string stack pop. asign the value to the string tracker for preceeding level. At the end,
# return the string tracker

# Your code here along with comments explaining your approach

class Solution:
    def __concat(self,count,string):
        return ''.join([string for num in range(count)])
    
    def decodeString(self, s: str) -> str:
        # substring tracker
        currStr = ""
        # Base
        if not s or len(s) == 0:
            return str(currStr)
        # number tracker
        num = 0
        # Stacks to store numbers and substrings
        numStack = []
        charStack = []
        
        for char in s:
            # If the character is a digit
            if char.isdigit():
                # Appending it to existing number in case its a 2 digit number
                num = num * 10 + int(char)
            elif char == '[':
                # When opening bracket is found push the current numtracker and stringtracker to
                # respective stacks
                numStack.append(num)
                charStack.append(currStr)
                # resetting number tracker and string tracker for next level
                num = 0
                currStr = ""
            # When closing bracket is found    
            elif char == ']':
                # Pop the numStack and charStack
                # Multiply the string Tracker by the value of numStack pop
                # Append the charStack pop value to the product and 
                # update this new string as string tracker for the upper level
                count = numStack.pop()
                currStr = charStack.pop() + self.__concat(count,currStr)
            # If the char is a string append it to string tracker
            else:
                currStr += char
        # return the final string tracker at the end 
        return currStr