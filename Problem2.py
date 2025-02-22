# Problem 2 : Decode String
# Time Complexity : O(|currStr|)
# Space Complexity : O(|currStr|)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
class Solution:
    def decodeString(self, s: str) -> str:
        # using stack to store the (prevStr, repeatCount)
        stack = []
        # variable to store the current string
        currStr = ''
        # variable to store current number
        currNum = 0

        for ch in s:
            # check if the character is digit
            if ch.isdigit():
                # calculate the current number from the character 
                currNum = currNum * 10 + int(ch)
            # if the character is '['
            elif ch == '[':
                # append the current number and current string in the stack
                stack.append((currStr, currNum))
                # reset the curren number and string
                currStr = ''
                currNum = 0
            # if the character is ']'
            elif ch == ']':
                # pop the prevStr, num 
                prevStr, num = stack.pop()
                # multiply the current strting by number and append to parent string
                currStr = prevStr + num * currStr
            # if the character is an alphabet then add to current string
            else:
                currStr += ch
        return currStr

