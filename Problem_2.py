# Runs on Leetcode

# Runtime - O(n)
# Memory - O(n)


class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return s
        NumStack = []
        StrStack = []
        CurrentNum = 0
        CurrentString = ""
        NewString = ""
        for char in s:
            if char.isdigit():
                CurrentNum = (CurrentNum*10)+ int(char)
            elif char == '[':
                NumStack.append(CurrentNum)
                StrStack.append(CurrentString)
                CurrentNum = 0
                CurrentString = ""
            elif char == ']':
                NewString = CurrentString * NumStack.pop()
                CurrentString = StrStack.pop()
                CurrentString += NewString
            else:
                CurrentString += char
        return CurrentString
