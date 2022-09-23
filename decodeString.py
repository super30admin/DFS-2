#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution(object):
    def __init__(self):
        self.i = 0
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        curr_str = ""
        num = 0
        while (self.i < len(s)):
            c = s[self.i]
            if c.isdigit():
                num = num*10 + int(c)-int('0')
                self.i += 1
            elif c == '[':
                self.i += 1
                decoded= self.decodeString(s)
                for j in range(num):
                    curr_str += decoded
                num = 0
            elif c == ']':
                self.i+= 1
                return curr_str
            else:
                curr_str += c
                self.i+=1
        
        return curr_str
    