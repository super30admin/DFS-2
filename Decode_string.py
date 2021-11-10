
class Solution:
    def decodeString(self, s: str) -> str:
        nums = ['1','2','3','4','5','6','7','8','9','0']
        stack = []
        self.final = ''
        i = 0
        while i < len(s):
            print(stack,s[i])
            if s[i] == ']':
                
                temp = ''
                j = len(stack) - 1
                while stack[j] != '[':
                    temp += stack.pop()[::-1]
                    j -= 1
                temp = temp[::-1]
                
                stack.pop()
                
                mul = ''
                j = len(stack) - 1
                while j >= 0 and stack[j] in nums:
                    mul += stack.pop()
                    j -= 1
                mul = int(mul[::-1])
                
                stack.append(int(mul) * temp)
            else:
                stack.append(s[i])
            i += 1
        return ''.join(stack)