#Time Complexity: O(n)
#Space Complexity:O(n)
#Ran successfully on Leetcode: Yes
# Algorithm :

# traverse the string,

# Traverse the string given
# Whenever we encounter '[', we append currdtring and currnum in to the stack 
# if we encounter closing bracket, we pop out num and the char in string and evaluate curr string as sum of previous string + num*currstring
# if the encounter element is number, we multiply it by 1- and add to the character. 
# If the encountered element is a character, we just add it to the currstring. 


class Solution(object):
    def decodeString(self, s):
        stack = []; curNum = 0; curString = ''
        for c in s:
            if c == '[':
                stack.append(curString)
                stack.append(curNum)
                curString = ''
                curNum = 0
            elif c == ']':
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num*curString
            elif c.isdigit():
                curNum = curNum*10 + int(c)
            else:
                curString += c
        return curString 
