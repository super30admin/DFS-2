#Time Complexity : O(n)
#Space Complexity : O(2n)
#Any problem you faced while coding this : -

#The approach is a standard level-order traversal using a two queues - one for storing the suffix numbers and the other one for storing the characters in between. At every opening bracket, we append the number and the preceeding characters. At every closing bracket, we pop the characters and append it with the count from the number stack.

class Solution:
    def decodeString(self, s: str) -> str:
        numStack, strStack = [], []
        currNum, currStr = 0, ''

        for ch in s:
            if ch.isdigit():
                currNum = currNum * 10 + int(ch)
            elif ch == '[':
                numStack.append(currNum)
                strStack.append(currStr)
                currNum, currStr = 0, ''
            elif ch == ']':
                count = numStack.pop()
                lastStr = strStack.pop()
                currStr = lastStr + currStr * count
            else:
                currStr += ch

        return currStr
