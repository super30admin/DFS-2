'''
TC:O(n)
SC: O(n)
'''


class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return s
        stnum = []
        ststr = []
        curstr = ''
        currnum = 0
        popped = 0
        temp = ''
        for c in s:
            if c.isdigit():
                currnum = currnum * 10 + int(c)
            elif c == '[':
                stnum.append(currnum)
                ststr.append(curstr)

                currnum = 0
                curstr = ''
            elif c == ']':
                popped = stnum.pop()
                temp = ''

                for i in range(0, popped):
                    temp += curstr
                curstr = ststr.pop() + temp
            else:  # Encounter alphabet
                curstr += c

        return curstr