# SC====>O(n)
# TC====>O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        word = ""
        num = 0
        s1 = []
        s2 = []
        for i in range (len(s)):
            char = s[i]
            if char.isdigit():
                num = num * 10 + (ord(char)-ord('0'))
            elif char == '[':
                s1.append(word)
                s2.append(num)
                word = ""
                num = 0
            elif char == ']':
                temp = s2.pop()
                curr = ""
                for j in range(temp):
                    curr += word
                word = s1.pop() + curr 
            else:
                word += char
        return word