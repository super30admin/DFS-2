# O(maxK n) time, maxK is max value of k and n is length of given string: overall we traverse string of size n and iterate it k times to decode pattern
# O(m + n), m and n are letters count and digits count

class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ''
        
        li_str = list()
        li_num = list()
        
        curstr = ''
        num = 0
        
        for i in range(len(s)):
            if s[i].isdigit() == True:
                num = num * 10 + int(s[i])
            elif s[i].isalpha() == True:
                curstr += s[i]
            elif s[i] == '[':
                li_str.append(curstr)
                li_num.append(num)
                curstr = ''
                num = 0
            else:
                count = li_num.pop()
                curstr = curstr * count
                strr = li_str.pop()
                curstr = strr + curstr
        
        return curstr



# Recursion Approach

class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:
            return None
        
        num = 0
        st = ''
        
        while self.i < len(s):
            if s[self.i].isalpha():
                st += s[self.i]
                self.i += 1
            elif s[self.i].isdigit():
                num = num*10 + int(s[self.i])
                self.i += 1
            elif s[self.i] == '[':
                self.i += 1
                decoded = self.decodeString(s)
                # repeat no of times as num
                a = decoded * num
                st = st + a
                num = 0
            else:
                self.i += 1
                return st

        return st