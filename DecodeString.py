#TC:  O(n*m), where 
# n is the length of the input string and 
# m is the maximum number that can appear in the input string.

#SC:  O(n*m)

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []   
        for i in range(len(s)):
            if s[i] != ']':
                stack.append(s[i])
            else:
                substr = ""              
                while stack[-1] != '[':
                    substr = stack.pop() + substr
                stack.pop()

                k = ""
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                stack.append(int(k) * substr)

        return "".join(stack)