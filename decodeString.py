# Time Complexity : O(n), where n is the length of the resultant string
# Space Complexity : O(n), where n is the length of the resultant string
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # This approach will maintain two stack to store string and integers respectively. in case of an
    # opening bracket, the current number and string is added to the stacks. in case of a closing bracket,
    # the stacks are popped and the string is processed a said number of times and added to the result
    def decodeString(self, s):
        if not s:
            return s
        strStack, numStack = [], []
        strTemp, numTemp = "", ""

        for i in s:
            # case opening bracket
            if i == '[':
                numTemp = int(numTemp)
                strStack.append(strTemp)
                numStack.append(numTemp)
                strTemp, numTemp = "", ""
            # case closing bracket
            elif i == ']':
                toProd = numStack.pop()
                temp = ""
                for _ in range(toProd):
                    temp += strTemp
                strTemp = strStack.pop()
                strTemp += temp
            # case digit
            elif i.isdigit():
                numTemp += i
            # case alphabet
            else:
                strTemp += i
        return strTemp
