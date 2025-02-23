# DFS Recursive Approach --
# TC - O(n * k)
# SC - O(n)

class Solution:
    def __init__(self):
        self.i = 0

    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0: return ""
        # i = 0
        num = 0
        currstr = ""

        s_len = len(s)

        while self.i < s_len:
            # case 1: if char is a num
            if s[self.i].isdigit():
                num = num * 10 + int(s[self.i])
                self.i += 1
            # case 2: s[i] is opening bracket
            elif s[self.i] == "[":
                self.i += 1
                # recursive call
                decode = self.decodeString(s)
                # multiply the decode str num times
                newStr = num * decode
                # append to currstr
                currstr += newStr
                # reset num to 0
                num = 0
            elif s[self.i] == "]":
                self.i += 1
                return currstr
            else:
                # s[i] is an alphabet
                currstr += s[self.i]
                self.i += 1

        return currstr