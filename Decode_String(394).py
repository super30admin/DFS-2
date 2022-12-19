# Time Complexity: O(maxK*n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    # Recursive Solution
    def __init__(self):
        self.index = 0

    def decodeString(self, s: str) -> str:
        nums = 0
        curr = ""

        while self.index<len(s):
            char = s[self.index]
            if char.isdigit():
                self.index+=1
                nums = nums*10 + int(char)
            elif char=="[":
                self.index+=1
                #similar to pushing the current string in the stack
                decoded = self.decodeString(s)
                newStr = decoded*nums
                curr = curr + newStr
                nums = 0
            elif char=="]":
                self.index+=1
                return curr
            else:
                self.index+=1
                curr = curr + char
        return curr

# Here we maintain 2 stacks one would store the number and the other the character/s related to that number
# if we ecounter a digit we multiply the previous num and add it to the nums so it takes care of the cases
# where the number is a 2 digit or more
# if elem is [ it means that the number has ended and we add it to the nums stack
# and also the current string to the stack and reset both
# if a closing ] is found it means that the string at top needs to be repeated has been completed
# so we pop from the numstack and multiply it by the number
# then we pop from the string stack and add it to the string
# if we encounter a character we just add it to the curr string

# Time Complexity: O(m*n)
# Space Complexity: O(m+n)

    # Iterative 2 stack
    # def decodeString(self, s: str) -> str:
    #     nums = 0
    #     curr = ""
    #     numStack = list()
    #     strStack = list()

    #     for elem in s:
    #         if elem.isdigit():
    #             nums = nums*10 + int(elem)
    #         elif elem=="[":
    #             numStack.append(nums)
    #             strStack.append(curr)
    #             nums = 0
    #             curr = ""
    #         elif elem=="]":
    #             newStr = curr*numStack.pop()
    #             curr = strStack.pop() + newStr
    #         else:
    #             curr = curr + elem

    #     return curr