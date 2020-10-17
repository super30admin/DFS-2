# TC: O(N)
# SC: O(N)
# Yes, It ran on leetcode

class Solution:
    def decodeString(self, s: str) -> str:
        stack = [["",1]]
        num = 0
        temp = ""
        
        for i in s:
            if i.isdigit():
                num = int(i)
            
            elif i=="[":
                stack.append([temp,num])
                num = 0
                
            elif i=="]":
                word,n = stack.pop()
                stack[-1][0] += word*n
                
            else:
                stack[-1][0]+=i
            print(stack)
            
        return stack[0][0]