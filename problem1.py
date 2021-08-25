#decodestring
#space complexity: O(KxN)
#time complexity: O(KN) where k is the number of numbers and N is the number of alphabet characters

class Solution(object):
    def decodeString(self, s):
        stack = []
        curNum = 0 
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
                curString = prevString + num*curString
            elif c.isdigit():
                curNum = curNum*10 + int(c)
            else:
                curString += c
        return curString
