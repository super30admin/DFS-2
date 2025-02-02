class Solution:
    # DFS approach
    # TC : O(n)
    # SC : O(n)
    def decodeString(self, s: str) -> str:
        stack = []
        resstr = ''
        tempnum = 0
        for c in s:
            if c.isdigit():
                tempnum = (tempnum*10) + int(c)
            elif c == '[':
                stack.append(tempnum)
                stack.append(resstr)
                tempnum = 0
                resstr = ''
            elif c == ']':
                strv = stack.pop()
                numv = stack.pop()
                resstr = strv + resstr * numv
            else:
                resstr += c
        while stack:
            resstr = stack.pop()+resstr
        return resstr