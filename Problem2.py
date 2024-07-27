#This code solves the problem of decoding a string encoded with patterns like "3[a2[c]]" which means "accaccacc". To achieve this, I used a stack (st) to manage characters and numbers while parsing the input string s. As I iterate through each character in s, I push characters onto the stack until I encounter a closing bracket ']'. When I find a ']', I pop characters from the stack until I reach the corresponding '[', forming the substring to be repeated. Next, I pop digits from the stack to form the repetition count, convert it to an integer, and push the repeated substring back onto the stack. This process continues until all characters are processed. Finally, I join the stack's contents to form the decoded string. The time complexity of this approach is O(n), where n is the length of the string, because each character is processed once. The space complexity is also O(n) due to the storage requirements of the stack.

class Solution:
    def decodeString(self, s: str) -> str:
        
        ans = ""
        nums = "0123456789"
        st = []
        
        for ch in s:
            if ch == ']':
                temp_str = ""
                while st[-1] != '[':
                    temp_str = st.pop() + temp_str
                st.pop()

                num = ""
                while st and st[-1] in nums:
                    num+= st.pop()
                num = int(num[::-1])
                
                while num > 0:
                    st.append(temp_str)
                    num-=1
            else:
                st.append(ch)
                
        ans = "".join(map(str,st))
        return ans