# Time: product of all the nums

# Have a number stack to keep track of all the numbers encountered and str stack to track the strings encountered
# Loop through all the characters in the string. Now for a character we have 4 choices either a digit a '[' or a ']' or a character.
# so if it is a digit then we need to see if we have encountered a digit before hence we need a currNum variable to keep track of it then we combine and then assign the current number
# The else condition in the code means we encounter another character so in that case we keep track of the current string and keep on adding the characters until we encounter something else
# If we encounter a '[' then we need to add the currNum and currStr in the stack to keep track of the parent and also change both of them to their original values to move forward
# The ']' is when we know that the processing of the child is done so at that point we process the child by repeating the string at the top of the stack for num at top of numStack times then we make the currStr to be equal to the whole decoded string
class Solution:
    def decodeString(self, s: str) -> str:
        numStack = []
        strStack = []
        currNum = 0
        currStr = ''
        for char in s:
            if char.isdigit():
                currNum = currNum * 10 + int(char)
            elif char == '[':
                numStack.append(currNum)
                strStack.append(currStr)
                currNum = 0
                currStr = ''
            elif char == ']':
                ct = numStack.pop()
                prevStr = strStack.pop()
                currStr = prevStr + (currStr * ct)
            else:
                currStr += char
        return currStr