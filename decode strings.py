# Time Complexity - O(n)
# Space Complexity - O(n)
class Solution:
    def decodeString(self, s: str) -> str:
        curr = []
        num = []
        temp_curr = ''
        temp_num='0'
        for i in range(len(s)):
            if s[i]=='[':
                num.append(temp_num)
                curr.append(temp_curr)
                temp_num='0'
                temp_curr=''
            elif s[i]==']':
                temp_curr = curr.pop()+int(num.pop())*temp_curr
            elif s[i].isdigit():
                temp_num = temp_num+s[i]
            else:
                temp_curr = temp_curr+s[i]
        return temp_curr
