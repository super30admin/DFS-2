class Solution:
    def decodeString(self, s: str) -> str:
        """
        TC: O(n)
        SC: O(no. of digits + no. of strings in the 's' string) 
        """

        # 1. base case
        if s == None or len(s) == 0:
            return s

        # 2. when the string is not empty
        stackInt = []
        stackStr = []
        currStr = ""
        currNum = 0
        temp = ""
        popped = 0

        for ch in s:

            if ch.isdigit():

                # convert the str to int and append
                # to existing num
                currNum = currNum * 10 + int(ch)

            elif ch == "[":

                # append to the both stacks
                stackInt.append(currNum)
                stackStr.append(currStr)
                # reset both currNum and currStr
                currNum = 0
                currStr = ""
            elif ch == "]":

                # pop the from the num stack
                popped = stackInt.pop()
                # append temp to currStr
                currStr += temp
                # append multiple times to create the pattern
                for i in range(popped):
                    temp += currStr
                # pop the string stack
                currStr = stackStr.pop() + temp
                temp = ""

            else:
                # alphabet
                currStr += ch
        # 3. Result
        return currStr
