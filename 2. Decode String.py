class Solution:
    def decodeString(self, s):
        # Time Complexity - O(maxK * n) where maxK is the max value of k and n is the length of the string
        # Space Complexity - O(m + n) - where m is the no of letters and n is the no of digits

        stack = [];
        curNum = 0;
        curString = ''

        for c in s:

            if c == '[':
                stack.append(curString)
                stack.append(curNum)
                curString = ''
                curNum = 0

            elif c == ']':
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num * curString

            elif c.isdigit():
                curNum = curNum * 10 + int(c)

            else:
                curString += c

        return curString