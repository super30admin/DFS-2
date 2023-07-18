# Time complexity : O(n)# Space complexity : O(n)
# The code ran on LeetCode
# Maintain two stacks one to store the previous string and the other to store the number of times a string should be repeated.
# Push elements to the respective stack until we reach a closing bracket. At the closing bracket, pop the number from number stack,
# repeat the current string and concatenate it with the top element in the stack.


class Solution:
    def decodeString(self, s: str) -> str:
        strStack = []
        numStack = []

        # strStack.appned('')
        curStr = ''; curNum = 0
        for i in range(len(s)):
            char = s[i]

            if char.isdigit():
                # print(curNum)
                if curNum == 0:
                    strStack.append(curStr)
                    curStr = ''
                curNum = curNum*10 + int(char)
            elif char == '[':
                numStack.append(curNum)
                curNum = 0
            elif char.isalpha():
                curStr += char
            elif char == ']':
                num = numStack.pop()
                temp = curStr*num
                st = strStack.pop()
                curStr = st + temp
        # print(strStack, numStack, curNum)
        return curStr