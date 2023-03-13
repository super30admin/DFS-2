#Time Complexity : O(N), N being the length of the final string. 
#Space Complexity : O(logN), N being the length of the final string. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : I had thought I understood the solution, but could 
#not solve it.  Had to look at solution again very closely. 
#Your code here along with comments explaining your approach in three sentences only
'''Using recursion, call self for every open bracket and return result every close bracket. At
the same time, parse through the characters in the string.
'''
class Solution:
    #initialize index to zero. 
    def __init__(self):
        self.index = 0
    def decodeString(self, s: str) -> str:
        num = 0
        string = ""
        while(self.index<len(s)):
            character = s[self.index]
            #if character is numeric, add to num. 
            if character.isnumeric():
                num = num*10+int(character)
                self.index = self.index+1
            # if open bracket, call itself, and add result to the string. 
            elif character=="[":
                self.index = self.index+1
                decoded = self.decodeString(s)
                for i in range(num):
                    string = string+decoded
                num = 0
            #if close bracket, return string to next recurse function.
            elif character=="]":
                self.index = self.index+1
                return string
            else:
            #if character is a non-digit, append to string. 
                string = string+character
                self.index = self.index+1
        return string

