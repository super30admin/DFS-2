#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []

        for char in s:
            if char == ']':
                #Extract characters inside brackets
                lst = []
                while stack and stack[-1] != '[':
                    lst.append(stack.pop())

                stack.pop()  # Remove the '['

                #Extract the number before the brackets
                k = 0
                base = 1
                while stack and stack[-1].isdigit():
                    k = k + (int(stack.pop()) * base)
                    base *= 10

                #Decode the string
                for i in range(k):
                    for l in reversed(lst):
                        stack.append(l)

            else:
                stack.append(char)

        return ''.join(stack)