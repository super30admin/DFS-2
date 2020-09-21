class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if(s == None or len(s) == 0):
            return s
        
        numStack = []
        strStack = []
        currNum = 0
        currStr = ""
        
        for _ in s:
            ch = _
            if ch.isdigit():
                currNum = currNum * 10 + int(ch)
            elif ch == "[":
                numStack.append(currNum)
                strStack.append(currStr)
                
                currNum = 0
                currStr = ""
            elif ch == "]":
                temp = ""
                topNum = numStack.pop()
                for i in range(0, topNum):
                    temp += currStr
                
                currStr = strStack.pop() + temp
            else:
                currStr += ch
        
        return currStr
