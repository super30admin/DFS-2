# 394. Decode String

'''
Leetcode all test cases passed: Yes
class Solution:
    def decodeString(self, s: str) -> str:0
        n is the length of the string
        Time Complexity: O(length of output) 
        Space Complexity: O(length of output)
'''
class Solution:
    def decodeString(self, s: str) -> str:
        parent = []
        nums = []
        curr = ""
        currNum = 0
        
        for ch in s:
            if ch.isdigit():
                currNum = int(str((currNum * 10) + int(ch)))
            elif ch == "[":
                parent.append(curr)
                nums.append(currNum)
                curr = ""
                currNum = 0
            elif ch == "]":
                curr *= nums.pop()
                curr = parent.pop() + curr
            else:
                curr += ch

        return curr
