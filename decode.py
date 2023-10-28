# // Time Complexity :O(n*pdt_of_nums_in_s) = O(output_len)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we are using a stack to keep track of parent nodes and baby nodes. we keep going - we push into the stack when theres a [
#  we pop when ]. 
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        ss=[]
        curr_num=0
        curr_str=""
        for i in range(len(s)):
            c =s[i]
            if(c.isdigit()):
                curr_num=curr_num*10 + int(c)
            elif(c=="["):
                ss.append([curr_num,curr_str])
                curr_num=0
                curr_str=""
            elif(c=="]"):
                count=ss.pop()
                print(count)
                baby=""
                for k in range(count[0]):
                    baby+=curr_str
                curr_str=count[1]+baby
            else:
                curr_str=curr_str+c
        return curr_str