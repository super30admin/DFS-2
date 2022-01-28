# tc : O(N) sc :O(N+N)
class Solution:
    def decodeString(self, s: str) -> str:
        char_st = []
        num_st = []
        curr = ''
        num = 0
        i = 0 
        res = ""
        while i <len(s):
            ch = s[i]
            #print(ch)
            if ch.isalpha():
                curr = curr+ch
                i+=1
            elif ch.isdigit():
                num = num*10 + int(ch)
                i+=1
            elif ch == "[":
                char_st.append(curr)
                num_st.append(num)
                num = 0
                curr = ""
                i+=1
            elif ch == "]":
                temp_num = num_st.pop()
                curr = curr*temp_num
                top = char_st.pop()
                curr = top + curr
                res = curr
                i+=1
            
        return curr
            
