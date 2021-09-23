#Time Complexity : O(n)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def decodeString(self, s: str) -> str:
        num = 0
        char = ""
        nums = deque()
        strs = deque()
        for i in s:
            if i.isnumeric():
                num = num*10 + int(i)
            elif i == "[":
                nums.append(num)
                strs.append(char)
                num = 0
                char = ""
            elif i == "]":
                rep = nums.pop()
                new_char = ""
                for x in range(rep):
                    new_char += char
                char = strs.pop()
                char += new_char
            else:
                char += i
        return char