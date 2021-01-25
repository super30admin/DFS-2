# Time Complexity : O(NK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using two Stacks. Iterate over the string s and check if it is digit then add it to num * 10 + digit
# Else if the string is "[" append the digit to numStack and append the current string to strStack and update the num to 0 and current string to empty
# Else if the string is "]" pop the numStack and multiply it with current string
# Append the output to new string and pop the strStack parent and append it to current string
# Else if it is a character then append it to current string


class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return None
        strStack = []
        numStack = []
        num = 0
        currStr = ""
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            elif s[i] == "[":
                numStack.append(num)
                strStack.append(currStr)
                num = 0
                currStr = ""
            elif s[i] == "]":
                newStr = ""
                times = numStack.pop()
                newStr += times * currStr
                currStr = strStack.pop() + newStr
            else:
                currStr += s[i]

        return currStr
