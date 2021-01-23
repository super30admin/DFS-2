# Time Complexity : O(n * max(k))
# Space Complexity : O(n)

class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        result = ''
        num = 0
        while self.i < len(s):
            c = s[self.i]
            if c in '0123456789':
                num = 10 * num + int(c)
                self.i += 1
            elif c == '[':
                self.i += 1
                result += self.decodeString(s) * num
                num = 0
            elif c == ']':
                self.i += 1
                return result
            else:
                result += c
                self.i += 1
            # print(self.i)
        
        return result