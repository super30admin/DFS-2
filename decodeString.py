#394. Decode String
# Time Complexity : O(n*k) length of decoded string
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return s
        strStack = []
        numStack = []
        currnum = ""
        currstr = ""
        for i in s:
            if i.isdigit():
                currnum += i                
            elif i == '[':
                numStack.append(int(currnum)) 
                strStack.append(currstr)
                currnum = ""
                currstr = ""
            elif i == ']':
                count = numStack.pop()
                temp = ""
                for i in range(count):
                    temp += currstr
                currstr = strStack.pop()
                currstr += temp
            else:
                currstr += i
        return currstr 
#394. Decode String
# Time Complexity : O(n*k) length of decoded string
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    i = 0
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return s
        
        currnum = 0
        result = ""
        while self.i < len(s):
            char = s[self.i]
            if char.isdigit():
                currnum = currnum * 10 + ord(char) - ord('0')
                self.i += 1
                
            elif char == '[':
                self.i += 1
                inner = self.decodeString(s)
                for j in range(currnum):
                    result += inner
                currnum = 0
                
            elif char == ']':
                self.i += 1 
                return result 
            else:
                result += char
                self.i += 1
        return result 