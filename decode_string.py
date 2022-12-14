class Solution:
    def decodeString(self, s: str) -> str:

        ## T.C = O(n)
        ## S.C = O(n)

        nums = []
        strs = []
        curr_str = ''
        curr_num = 0

        for i in range(len(s)):
            if s[i] == '[':
                nums.append(curr_num)
                strs.append(curr_str)
                curr_num = 0
                curr_str = ''
            elif s[i] == ']':
                n = nums.pop(-1)
                curr_str = curr_str*n
                curr_str = strs.pop(-1) + curr_str
            elif s[i].isdigit():
                curr_num = curr_num*10 + int(s[i])
            else:
                curr_str += s[i]
        
        return curr_str