# // Time Complexity : O(length_of_Result String)
# // Space Complexity : O(M+N) where M is the nuber of uniq string and N is the number og digits

class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return s
        stackStr = []
        stackNum = []
        currStr = ''
        currNum = 0
        for char in s:
            if char.isdigit():
                currNum = currNum*10+int(char)
            elif char == "[":
                stackStr.append(currStr)
                stackNum.append(currNum)
                currStr = ""
                currNum = 0
            elif char =="]":
                tempStr =stackStr.pop()
                tempNum = stackNum.pop()
                currStr = tempStr+ currStr*tempNum
            else:
                currStr += char
        return (currStr)