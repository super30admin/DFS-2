
# 2 STACKS Approach 
# NOTE: 4 CASES: 1) string[i].isdigit() 
              #  2) string[i].isalpha()
              #  3) string[i] == '['
              #  4) string[i] == ']'

# time : O(N)
# space : O(N)

class Solution:
    def decodeString(self, s):
        numstack =[]
        strstack = []
        curnum = 0
        curstr = ''

        for c in s:
            if c.isdigit():
                curnum = curnum*10 + int(c)
            elif c == '[':
                numstack.append(curnum)
                strstack.append(curstr)
                curnum = 0
                curstr = ''
            elif c == ']':
                times = numstack.pop()
                new_str = times * curstr
                curstr = strstack.pop()
                curstr += new_str
            else:
                curstr += c
        return curstr
        