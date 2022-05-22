# // Time Complexity : O(n) => len of output string
# // Space Complexity : O(B) => number of brackets in the string
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        numvar = 0
        currstr = ""
        numstack = deque()
        strstack = deque()
        for char in s:
            # if char is number
            if char.isdigit():
                numvar = numvar * 10 + ord(char) - ord('0')
            # if char is an alphabet
            elif char.isalpha():
                currstr = currstr + char
            # if char is open braces
            elif char == "[":
                numstack.append(numvar)
                strstack.append(currstr)
                numvar = 0
                currstr = ""
            # if char is close braces
            else:
                mul = numstack.pop()
                tempstr = ""
                for i in range(1, mul+1):
                    tempstr = tempstr + currstr
                currstr = tempstr
                currstr = strstack.pop() + currstr
        return currstr
