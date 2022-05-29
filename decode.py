#Approach: Maintaining stacks for number and characters and then multiplying cur string with number and appending it to result
#Time Complexity O(Output) ,O(N) + max(K) * curstring
#Space Complexity O(N) + max(K)*curstring
#It successfully runs on leetcode   
class Solution:
    def decodeString(self, s: str) -> str:
        ss, ns = [], []
        cur, num= "", 0
        for i in range(len(s)):
            if s[i].isnumeric():
                num = num * 10 + int(s[i])
            if s[i].isalpha():
                cur+=s[i]
            if s[i] == "[":
                ss.append(cur)
                ns.append(num)
                cur,num = "",0
            if s[i] == "]":
                cur = ss.pop() + cur * ns.pop()
        return cur

#Approach : Recursion by maintaining index value globally             
#Time Complexity O(Output) ,O(N) + max(K) * curstring
#Space Complexity recursion maximum depth
#It successfully runs on leetcode 

class Solution:
    def __init__(self):
        self.i = 0
    def decodeString(self, s: str) -> str:
        if not s : return ""
        cur, num= "", 0
    
        while self.i < len(s):
            if s[self.i].isnumeric():
                num = num * 10 + int(s[self.i])
                self.i+=1
            elif s[self.i].isalpha():
                cur+=s[self.i]
                self.i+=1
            elif s[self.i] == "[":
                self.i+=1
                string = self.decodeString(s)
                cur += string* num
                num = 0
            else:
                self.i+=1
                return cur
        return cur