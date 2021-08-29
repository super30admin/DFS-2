"""
Time Complexity : O(kn) where n is length of string and k is the repeat no.
Space Complexity : O(kn) where n is length of string and k is the repeat no.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def decodeString(self, s: str) -> str:
        if len(s) == 0:
            return s
        currString = ''
        numStr = ''
        numStack = []
        strStack = []
        # Loop through the string charcaters if it is a digit then append it to 
        # the num string else if it is a '[' append the number to the numStack and 
        # character to the strStack and reset the number and curr strings
        # and when we encounter the ']' just pop the strings from string stack and 
        # append it to the num of times the string occured while if we find a character
        # we just add i to the currString
        for i in s:
            if i.isdigit():
                numStr += i
            elif i == '[':
                numStack.append(numStr)
                strStack.append(currString)
                numStr = ''
                currString = '' 
            elif i == ']':
                currString = strStack.pop() + (currString * int(numStack.pop()))
            else:
                currString += i
        return currString