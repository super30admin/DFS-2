# Passed on leet code(394)
# time - O(N), space - O(N)
# Loop through given string and maintain a stack with set.
# Here, we have 4 cases, for numbers, for character, for open brace and closed brace. At the end return the expanded string.
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        currStr = ''
        currNum = 0
        for c in s:
            # case 1 - if the character is the number
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            # case 2 - if the character is open brace
            elif c == '[':
                stack.append((currNum,currStr))
                currNum = 0
                currStr = ''
            # case 3 - if the character is closing brace
            elif c == ']':
                times,prev = stack.pop()
                # as we encounter a closing brace, pop the num stack and multiply it with current string and add the previous string from string stack.
                currStr = prev + times * currStr
                # multiline code
                '''
                newStr = ''
                for i in range(times):
                    newStr += currStr
                currStr = strStack.pop()
                currStr += newStr
                '''
            # case 4 - when the character is alphabet
            else:
                currStr += c
        return currStr