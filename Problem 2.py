class Solution:
    def decodeString(self, s: str) -> str:
        '''
        i = 0, num = 3, st = 1, end = 3
            33[a]
        s =  3 [ a 
        '''
        
        stack = deque()

        i = 0

        while i < len(s):
            
            if s[i].isdigit():
                num = 0
                while s[i].isdigit():
                    num = num*10 + int(s[i])
                    i += 1
                stack.append(num)
                i-=1

            elif s[i] == "]":
                temp = ""
                while stack[-1] != "[":
                    temp += stack.pop()
                stack.pop()
                temp *= stack.pop()
                j = len(temp) - 1
                while j >= 0:
                    stack.append(temp[j])
                    j-=1
            
            else:
                stack.append(s[i])

            i += 1
        

        return "".join(stack)
