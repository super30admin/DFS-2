class Solution:
    def decodeString(self, s: str) -> str:

        def fixNumber(numStr):
            rev = numStr[::-1]
            return int(rev)

        stack = []

        for char in s:
            if char != "]":
                stack.append(char)
            else:
                currString = ""
                currNumber = ""

                while stack[-1] != "[":
                    currString += stack.pop()

                currString = currString[::-1]

                stack.pop()

                while len(stack) > 0 and stack[-1].isnumeric():
                    currNumber += stack.pop()

                if currNumber == "":
                    return currString
                currNumber = fixNumber(currNumber)

                res = currNumber * currString
                stack.extend(res)

        return "".join(stack)
