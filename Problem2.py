#Time complexity: O(n)
#Space complexity:  O(n)
#Works on leetcode: yes
#Approach: Here we keep a stack and variables alpha and d for digits to tackle the problem. Whenever we get a digit, we add it
#to the d, if we get alphabet we add it to alpha and wheneven we get [, we add the pair of (alpha, digit as int) to stack
# and reset the alpha and d variables. Whenever we get ], it means we have to pop the pair of alphabets and digits from the stack
# and update the alpha as popped previous alpha plus alpha*digit 
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        alpha, d =  "",""
        for c in s:
            if c.isdigit():
                d += c
            elif c.isalpha():
                alpha += c
            elif c=="[":
                stack.append((alpha,int(d)))
                alpha, d = '',''
            else:
                pre, n = stack.pop()
                alpha = pre + alpha*n
        return alpha