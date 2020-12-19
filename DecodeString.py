
# Approach: DFS

# Here we will maintain two stacks. One to hold numeric value and other to hold string value. Different operations with both stacks and strings are done upon encountering following characters in the string:
# 1) Numeric value: Store it in a variable. If 32 is encountered then store 32 not 3
# 2) [ : Push the numeric value stored in the variable on to numbers stack. 
#        Push the string formed uptill now to strings stack.
#        Intialize the number and string variable to null 
# 3) ] : Pop the value from the stack which will serve as the number of time the string has to be repeated
#        Construct the new string by repitions. Pop the string from strings stack and append the newly formed string to it which will serve as the current string.
# If none of them is encountered then simply add the character to current string

# Space complexity: O(n) ; n = length of the string given
# Time complexity: O(n * j); j = maximum number present in the string
class Solution:
    def decodeString(self, s: str) -> str:
        if s == None or len(s) == 0:
            return s
        
        currString = ""
        num = 0
        nums = []
        strings = []
        
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + ord(c) - ord('0')
            elif c == "[":
                nums.append(num)
                strings.append(currString)
                num = 0
                currString = ""
            elif c == "]":
                times = nums.pop()
                newString = ""
                for j in range(times):
                    newString += currString
                currString = strings.pop() + newString
                
            else:
                currString += c
                
        return currString
                