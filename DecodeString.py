# Time Complexity :
# O(N)  , N= length of string

# Space Complexity :  
# O(N) , N= length of string


class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s or len(s) == 0:
            return ""
        
        numStack = []
        strStack = []

        num = 0
        curr = ""

        for c in s:
            if c.isdigit():
                num = num*10 + (ord(c)-ord('0'))
                
            elif c == '[':
                # push the current values of "num" and "curr" to respective stacks
                numStack.append(num)
                strStack.append(curr)
                num = 0
                curr = ""

            elif c == ']':
                times = numStack.pop()
                innerStr = ""
                for i in range(times):
                    innerStr += curr
                curr = strStack.pop() + innerStr
                

            else:
                curr += c

        
        return curr