# Time Complexity:  O(n)
# Space Complexity:  O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        numStack = []
        strStack = []
        num = 0
        curr = ""
        index = 0
        while(index < len(s)):
            ch = s[index]
            if ch.isdigit():
                num = num*10 + int(ch)
            if ch.isalpha():
                curr = curr + ch
            if ch =="[":
                numStack.append(num)
                num = 0
                strStack.append(curr)
                curr = ""
            if ch =="]":
                count = numStack.pop()
                child = curr * count
                parent = strStack.pop()
                curr = parent + child
            index += 1
        return curr