# // Time Complexity : O(n) where n is the length of the output string s
# // Space Complexity : O(n) for the auxiliary stacks used to store numbers and strings
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
# We maintain 2 stacks for string and numbers (there might be '2' / '22').if we find "]" we update curr sting by poping from both number and string stack


class Solution:
    def decodeString(self, s: str) -> str:
        #maintain 2 stacks one for num and one for curr str
        curr_str,curr_num="",0
        str_st,num_st=[],[]
        for i in s:
            if i.isalpha():
                curr_str+=i
            elif i.isnumeric():
                curr_num= curr_num*10 + (ord(i)-ord('0'))
            elif i=="[":
                str_st.append(curr_str)
                if curr_num:
                    num_st.append(curr_num)
                curr_str,curr_num="",0
            elif i=="]":
                number=num_st.pop()
                curr_str=curr_str*number
                s=str_st.pop()
                curr_str=s+curr_str
                # str_st.append(curr_str)
                # curr_str,curr_num="",0
        # print(str_st,num_st,curr_str)
        return curr_str



            
