'''
Time Complexity :O(n * max(nums)) where n is length of the string and nums is numbers in encoded string
Space Complexity : O(n) where n is number of opening brackets
Did this code successfully run on Leetcode : YES
'''
class Solution:
    def decodeString(self, s: str) -> str:
        result = ""
        myStack = []
        num = 0
        for index in range(len(s)):
            ch = s[index]
            if ch.isdigit():
                num = num * 10 + int(ch)
            elif ch == "[":
                myStack.append([num, result])
                num = 0
                result = ""
            elif ch == "]":
                curr = myStack.pop()
                count = curr[0]
                temp = curr[1]
                for _ in range(count):
                    temp += result
                result = temp
            else:
                result += ch
        return result