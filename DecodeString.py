'''
Solution:
1.  Maintain a stack or perform recursion to decode the given string embedded inside square braces and the operation to
    be performed will be based on the character that is being traversed.
2.  If the char is a digit, then update the number to number of times the current string has to be concatenated.
3.  If the char is an opening bracket, then push currently computed string and number to the stack and re-initialize them.
4.  If the char is an closing bracket, then pop the top element and update the final resultant string.
5.  If the char is a normal char, then just concatenate to the temporary string.
6.  Finally, return the resultant string.

Time Complexity:    O(n) for both iteration and recursion
Space Complexity:   O(n) for both iteration and recursion

--- Passed all testcases successfully on Leetcode
'''


class DecodeString_Stack:
    def decodeString(self, s: str) -> str:

        #   all required initializations
        currStr = ''
        currNum = 0
        stack = []
        cursor = 0
        digits = '0123456789'

        #   move the index till the end and perform required operation based on the type of character encountered
        while (cursor < len(s)):

            if (s[cursor] in digits):                       #   if the char is a digit, then update the number to number of times
                currNum = (currNum * 10) + int(s[cursor])   #   the current string has to be concatenated

            elif (s[cursor] == '['):                        #   if the char is an opening bracket, then push currently computed
                stack.append([currStr, currNum])            #   string and number to the stack and re-initialize them
                currStr = ''
                currNum = 0

            elif (s[cursor] == ']'):                        #   if the char is an closing bracket, then pop the top element
                                                            #   and update the final resultant string
                topElement = stack.pop()
                prevStr = topElement[0]
                prevNum = topElement[1]
                currStr = prevStr + (currStr * prevNum)

            else:                                           #   if the char is a normal char, then just concatenate to the
                currStr += s[cursor]                        #   temporary string

            cursor += 1                                     #   increment the cursor after every one of the above operations

        return currStr                                      #   return the final string


class DecodeString_Recursion:

    def __init__(self):
        #   all required initializations -- cursor should be a global variable
        self.cursor = 0
        self.digits = '0123456789'

    def decodeString(self, s: str) -> str:

        #   whenever recursion is called for a subproblem, both result string and number of times should be re-initialized
        result = ''
        times = 0

        while (self.cursor < len(s)):

            token = s[self.cursor]

            if (token in self.digits):                      #   if the char is a digit, then update the number to number of times
                self.cursor += 1                            #   the current string has to be concatenated
                times = (times * 10) + int(token)

            elif (token == '['):                            #   if the char is an opening bracket, then call recursion on subproblem
                self.cursor += 1
                innerResult = self.decodeString(s)
                result = result + (innerResult * times)     #   concatenate the inner string to the main string
                times = 0

            elif (token == ']'):                            #   if the char is an closing bracket, then return the result of subproblem
                self.cursor += 1
                return result

            else:                                           #  if the char is a normal char, then just concatenate to the temp string
                self.cursor += 1
                result += token

        return result                                       #   return the final string
