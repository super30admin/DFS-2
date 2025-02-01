# 2 stack approach, once we hit a open breacket update the num stack and curr stack witth current values and clear the stack, keep doing it until we hit the closed bracked. Now we pop and mutiply with num in stack we popped and add to the current char
# TC: O(n) where n is the final decoded string
# SC: O(h) where h is the depth of the recursive stack
# Yes, this worked in leetcode


class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        num = 0
        char = ""
        numstack = []
        charstack = []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':
                numstack.append(num)
                charstack.append(char)
                num = 0
                char = ""
            elif c == ']':
                times = numstack.pop()
                newchar = char * times
                char = charstack.pop() + newchar
            else:
                char += c
        return char