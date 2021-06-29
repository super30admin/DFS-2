#Time complexity for put and get: O(nk) where k is the max number in the string and n is the length
#Space complexity: O(nk)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    i = 0
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        # Recursive soln
        if s is None or len(s) == 0:
            return s
        curStr = ''
        curNum = 0
        #Parsing through the string
        while self.i < len(s):
            # if char is digit,multiply old num with 10 and add, accomodate multiple digits
            ch = s[self.i]
            self.i += 1
            if ch.isdigit():
                curNum = curNum*10 + int(ch)
                #if char is ch, append to current string
            if ch.isalpha():
                curStr = curStr + ch
            if ch == '[':
                child = self.decodeString(s)
                newStr = curNum * child
                curStr  = curStr + newStr
                curNum = 0
            if ch == ']':
                return curStr
        return curStr
        
        # #Normal 2 stack soln
        # #String stack
        # strSt = []
        # #number stack
        # numSt = []
        # curStr = ''
        # curNum = 0
        # #Parsing through the string
        # for ch in s:
        #     # if char is digit,multiply old num with 10 and add, accomodate multiple digits
        #     if ch.isdigit():
        #         curNum = curNum*10 + int(ch)
        #         #if char is ch, append to current string
        #     if ch.isalpha():
        #         curStr = curStr + ch
        #     #if char is opening braces, add to stack, as the old stuff would be processed later
        #     if ch == '[':
        #         strSt.append(curStr)
        #         numSt.append(curNum)
        #         #reset
        #         curStr = ''
        #         curNum = 0
        #     #if closing braces, then pop from both stack, use the number to multiple the curstr and append the popped string at the beginning
        #     if ch == ']':
        #         st = strSt.pop()
        #         numbr = numSt.pop()
        #         curStr = numbr*curStr
        #         curStr = st + curStr
        # return curStr
                