# 394. Decode String
# https://leetcode.com/problems/decode-string/
#
# Time complexity: O(n*k) n - length of input string;k - max of all the digits summed
#Space Complexity: O(n*k) - as the stack will store the strings in the stack. which will increase the stack size in mem
class Solution:
    def decodeString(self, s: str) -> str:
        

        curr_word = ""
        curr_num = 0
        word_st = []
        num_st = []

        for i in range(len(s)):
            #four cases: digit, [,], char
            if s[i].isdigit():
                curr_num = curr_num*10 + int(s[i])

            #add to stack curr num and word and reset for next round
            elif s[i] == "[":
                word_st.append(curr_word)
                num_st.append(curr_num)
                curr_word = ""
                curr_num = 0

            #retrieve parent from stack - add to it curr_num k num of times
            elif s[i] == "]":
                parent = word_st.pop()
                k = num_st.pop() #how many number of times this has to be repeated
                for j in range(k):
                    parent += curr_word
                curr_word = parent
            else:
                curr_word += s[i]
        
        return curr_word