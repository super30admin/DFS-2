# Brute Force Solution - Using a stack
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        for i in range(len(s)):
            if s[i] == ']':
                s1 = []
                while stack[-1] != '[':
                    s1.append(stack.pop())
                stack.pop()
                k = 0
                base = 1
                while stack and stack[-1].isnumeric():
                    k = k + int(stack.pop()) * base
                    base = base * 10
                
                while k != 0:
                    for j in reversed(range(len(s1))):
                        stack.append(s1[j])
                    k -= 1
                
            else:
                stack.append(s[i])
        
        return ''.join(stack)