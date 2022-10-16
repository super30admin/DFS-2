#Time Complexity: O(maxK^countK*n) where maxK is the maximum value of k ,
# countK is the count of nested k values and n is the max length of encode string
#Space Complexity: O(sum(maxK^countK*n))
#Did it run on leetcode: Yes

class Solution(object):
    def decodeString(self, s):
        stack = []; curNum = 0; curString = ''
        for c in s:
            if c == '[':
                stack.append(curString)
                stack.append(curNum)
                curString = ''
                curNum = 0
            elif c == ']':
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num*curString
            elif c.isdigit():
                curNum = curNum*10 + int(c)
            else:
                curString += c
        return curString