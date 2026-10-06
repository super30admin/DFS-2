# Time Complexity : O(NK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using two Stacks. Iterate over the string s and check if it is digit then add it to num * 10 + digit
# Else if the string is "[" append the digit to numStack and append the current string to strStack and update the num to 0 and current string to empty
# Else if the string is "]" pop the numStack and multiply it with current string
# Append the output to new string and pop the strStack parent and set it to current string
# Else if it is a character then append it to current string

class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        strstack = []
        numstack = []
        currstr = ""
        num = 0
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            elif s[i] == "[":
                numstack.append(num)
                strstack.append(currstr)
                currstr = ""
                num = 0
            elif s[i] == "]":
                count = numstack.pop()
                newstr = ""
                for j in range(count):
                    newstr += currstr
                newstr = strstack.pop() + newstr
                currstr = newstr
                
            else:
                currstr += s[i]
        return currstr
#Iterative

class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return "" 
        self.i = 0
        return self.helper(s)
    def helper(self, s):
        num = 0
        result = ""
        while self.i < len(s):
            if s[self.i].isdigit():
                num = num * 10 + int(s[self.i])
                self.i += 1
            elif s[self.i] == "[":
                self.i += 1
                substring = self.helper(s)
                currstr = substring * num
                result += currstr
                num = 0
            
            elif s[self.i] == "]":
                self.i += 1
                return result 
            else:
                result += s[self.i]
                self.i += 1
        return result

