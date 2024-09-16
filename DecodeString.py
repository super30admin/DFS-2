#Time Complexity : O(N) where N is number of element in Strings
# Space Complexity : O(N) is Number of element in string stored in stack

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        currentNum = 0
        currentStr = ""
        for i in s:
            if i.isdigit():
                currentNum = currentNum*10 + int(i)
            elif i == "[":
                stack.append(currentNum)
                stack.append(currentStr)
                currentStr = ""
                currentNum = 0
            elif i == "]":
                oldstr = stack.pop()
                repeats = stack.pop()
                currentStr = oldstr + repeats*currentStr
            else:
				currentStr += i
        return currentStr