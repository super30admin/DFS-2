
# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        letter_stack = []

        counter = -1
        sum_ = []
        for i in s:
            if i.isdigit():
                i = int(i)
                sum_.append(i)
                counter = counter + 1
            elif i == '[':
                letter_stack.append(i)
                total = 0
                for j in sum_:
                    total = total + j * 10**counter
                    counter = counter - 1
                num_stack.append(total)
                counter = -1
                sum_ = []
            elif i == ']':
                rep = []
                temp = letter_stack.pop()
                while temp != '[':
                    rep.append(temp)
                    temp = letter_stack.pop()
                rep.reverse()
                letter_stack = letter_stack + rep * num_stack.pop()
                
            else:
                letter_stack.append(i)
                

        return ''.join(letter_stack)

        
            