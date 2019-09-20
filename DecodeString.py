"""
The idea here is maintain a stack and a temp array we push all elements with the numbers at once in the
stack, now we pop the letters and store them in the array and if we enounter '[' we just pop out without 
storing, now we store the numbers in the string l and convert the string to int, after that we multiply
the last element in the array with the value of l, and again push it into the stack, finally once we are
done we join all the pushed elements before and return.

Time complexity - O(N)
Space Complexity - O(N^2)
"""
def decodeString(self, s):
        stack = []
        
        for x in s:
            if x != ']':
                stack.append(x)
            else:
                t = []
                while stack and stack[-1] != '[':
                    t.append(stack.pop())
                stack.pop()
                l = ''
                while stack and stack[-1].isdigit():
                    l = l+stack.pop()
                l = int(l[::-1])
                stack.append((''.join(t[::-1]))*int(l))
                
        return ''.join(stack)