#// Time Complexity : length of the result 
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : using 2 stacks

class Solution:
    def decodeString(self, s: str) -> str:
        numstack = []
        charstack = []
        currnum = 0
        currstr = ''
        for c in s:
            if c.isdigit():
                currnum = 10 * currnum + int(c)
            elif c == '[':
                numstack.append(currnum)
                charstack.append(currstr)
                currnum = 0
                currstr = ''
            elif c == ']':
                count = numstack.pop()
                temp =''
                for k in range(count):
                    temp += currstr
                abc = charstack.pop()
                abc += temp
                currstr = abc                 
            else:
                currstr += c
        
        return currstr                

# Approach:
# 1. Create two stacks, one for numbers and one for characters.
#     2. Iterate through the string and keep track of the current number and string.
# 3. When you encounter a '[', push the current number and string onto the stacks and reset the currnum and currstr.
# 4. When you encounter a ']', pop the number and string off the stacks, and multiply the
# string by the number. Then, push the result onto the character stack.
# 5. Continue iterating through the string until you reach the end.



        