# TC - O(max(num)*N)
# SC - O(M+N) where N is the length of the string and M is the # of numbers

class Solution:
    def decodeString(self, s: str) -> str:
        countS, stringS, num, currS = [], [], 0, ''
        for ch in s:
            if ch.isdigit():
                num = num*10 + int(ch)-0
            elif ch == '[':
                countS.append(num)
                stringS.append(currS)
                currS = ''
                num = 0
            elif ch == ']':
                n = countS.pop()
                currS = stringS.pop() + currS*n
            else:
                currS += ch
        return currS
