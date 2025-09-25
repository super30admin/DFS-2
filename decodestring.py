# Time Complexity : O(N) where N is the size of the string that needs to be decoded
# Space Complexity : O(N) where N is the size of the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using two stacks to keep track of the numbers and the strings.
# I am iterating through the string and for each character, I am checking if it is a digit, a letter, a '[' or a ']'.
# If it is a digit, I am updating the current number.
# If it is a '[', I am pushing the current string and current number onto their respective stacks and resetting them.
# If it is a ']', I am popping the top string and number from their respective stacks and updating the current string by 
# repeating the current string 'number' times and appending it to the popped string.
# If it is a letter, I am appending it to the current string. In the end, I am returning the current string.


from typing import List

class Solution:
    def decodeString(self, s: str) -> str:
        numSt = []
        strSt = []
        currNum = 0
        curStr = []
        for i in  range(len(s)):
            c = s[i]
            if c.isdigit():
                currNum = currNum*10 + int(c)
            elif c == "[":
                strSt.append(curStr)
                numSt.append(currNum)
                currNum = 0
                curStr = []
            elif c == "]":
                pnt = strSt.pop()
                cnt = numSt.pop()
                curStr = pnt + curStr * cnt 
            else:
                curStr.append(c)
        return ''.join(curStr)
            


        