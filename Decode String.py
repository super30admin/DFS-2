# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        numst = []
        charst = []
        res = ''
        currstr = ''
        currnum = 0
        for i in range(len(s)):
            if s[i].isdigit():
                currnum = currnum * 10 + int(s[i])
            elif s[i] == '[':
                numst.append(currnum)
                charst.append(currstr)
                currnum = 0
                currstr = ''
            elif s[i] == ']':
                itr = numst.pop()
                currstr *= itr
                currstr = charst.pop() + currstr
            else:
                currstr += s[i]
                # print(currstr)
        return currstr