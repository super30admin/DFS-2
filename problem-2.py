# Time Complexity : O(n)
# space complexity : O(n)

# Approach :

# if the character is a number, calculate it using the formula and convert it to a number
# if the character is a character, keep appeding it to a char variable
# if the character is a [, push number to numstack, and character to character stack and reinitialize number to 0 and character to ""
# if the character is a ], pop both the number and character from the stack, create the new string n times and the final string will be the popped string and the repeated string

class Solution:
    def decodeString(self, s: str) -> str:

        numStack = []
        charStack = []
        number = 0
        stringVal = ""

        for i in s:

            if i.isdigit():
                number = number * 10 + int(i)

            elif i == "[":
                numStack.append(number)
                charStack.append(stringVal)
                number = 0
                stringVal = ""

            elif i == "]":
                poppedNum = numStack.pop()
                prevChar = charStack.pop()
                stringVal = prevChar + (poppedNum*stringVal)

            else:
                stringVal += i

        return stringVal


# Recursion
# Time Complexity : O(n)
# space complexity : O(n)

# Approach :

# run a while loop till len(s)
# if the character is a number, calculate it using the formula and convert it to a number and increment i
# if the character is a character, keep appeding it to a char variable and increment i
# if the character is a [, increment i, and recursively call the function to iterate inside the [, till ] is reached or till len(s)
# if the character is a ], increment i and return the new string


class Solution:

    def __init__(self):
        self.i = 0

    def decodeString(self, s: str) -> str:

        currString = ""
        number = 0

        while (self.i < len(s)):

            c = s[self.i]

            if c.isdigit():

                self.i = self.i+1
                number = (number * 10) + int(c)

            elif c == '[':

                self.i = self.i+1
                decodedString = self.decodeString(s)
                exactString = (decodedString * number)
                currString += exactString
                number = 0

            elif c == ']':

                self.i = self.i+1
                return currString

            else:
                self.i = self.i+1
                currString += c

        return currString
