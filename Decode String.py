# Time Complexity :  O(maxK.n)
# Space Complexity : O(m+n) here m is the number of letters(a-z) and n is the number of digits(0-9) in string s. In worst case, the maximum size of stringStack and countStack could be m and n respectively.

# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for i in s:
            if i != "]":
                stack.append(i)
            else:
                number = ""
                tempstr = ""
                while stack[-1] != "[":
                    tempstr = stack.pop() + tempstr
                stack.pop()
                while len(stack) > 0:
                    if stack[-1].isnumeric():
                        number = stack.pop() + number
                    else:
                        break
                tempstr = tempstr * int(number)
                stack.append(tempstr)
        return "".join(stack)