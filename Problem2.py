T.C: MaxK.N where MaxK is the maximum integer in the string and N is the legth of the string
S.C: O(N)
class Solution:
    def __init__(self):
        self.i = 0
    def decodeString(self, s: str) -> str:
        curr = ""
        num = 0
        while self.i < len(s):
            if s[self.i].isdigit():
                num = num*10+int(s[self.i])
                self.i += 1
            elif s[self.i] =="[":
                self.i +=1
                child = self.decodeString(s)
                curr = curr + (child*num)
                num = 0
               
            elif s[self.i] == "]":
                self.i += 1
                return curr
            else:
                curr += s[self.i]
                self.i += 1
        return curr
            
