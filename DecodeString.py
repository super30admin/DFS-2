# Time Complexity is O(n*k),  
# Space Complexity is O(n), where n is the length of string and k is the maximum number encoded in s
# Use two stacks one to store numbers and other for letters. Push the elements to stack whenever we encounter a open bracket
# and Pop them out when we encounter a closed bracket to update current string
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if(len(s) == 0):
            return ""
        
        numStack = []
        letStack = []
        num = 0
        currString = []
        for c in s:
            if(c.isdigit()):
                num = num*10 + int(c)
            elif(c.isalpha()):
                currString.append(c)
            elif(c == '['):
                numStack.append(num)
                letStack.append(''.join(currString))
                currString = []
                num = 0
            elif(c == ']'):
                prevNum = numStack.pop()
                prevString = letStack.pop()
                currString = [prevString,prevNum*"".join(currString)]
        return ''.join(currString)