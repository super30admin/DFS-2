class Solution:
    def decodeString(self, s):
        strSt = []
        numSt = []
        currStr = ''
        num = 0

        for ch in s:
            # when the ch is a digit
            if ch.isdigit():
                # multiply by 10
                num += (num * 10) + int(ch)
            # when ch is [
            elif ch == '[':
                numSt.append(num)
                strSt.append(currStr)
                num = 0
                currStr = ''
            # when ch is ]
            elif ch == ']':
                cnt = numSt.pop()
                decoded = currStr * cnt
                parent = strSt.pop()
                currStr = parent + decoded
            # when ch is a alphabet
            else:
                currStr += ch
        return currStr





sol = Solution()
s = "3[a]2[bc]"
print(sol.decodeString(s))
s = "3[a2[c]]"
print(sol.decodeString(s))
s = "2[abc]3[cd]ef"
print(sol.decodeString(s))