#space: O(n)
#time: O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        num=0
        string= ""
        stack = list()
        for char in s:
            # print('char -->',char)
            if char.isdigit():
                num = num*10 + int(char)
            elif char == "[":
                stack.append([num,string])
                num=0
                string=""

            elif char == "]":
                temp= stack.pop()
                string =   str(temp[1]+temp[0]*string)
            
            else:
                string= string + char
        return string
