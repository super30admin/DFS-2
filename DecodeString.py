#Time Complexity: O(K*n)
#n is the input string length, K=multiply all k(numbers) in the string
#Space Complexity: O(K*n) Same as time complexity
class Solution:
    def decodeString(self, s: str) -> str:
        num_stack=[]
        alph_stack=[]
        curr_val=0
        curr_str=""
        for i in s:
            if i.isalpha():
                curr_str=curr_str+i
            elif i == "[":
                num_stack.append(curr_val)
                alph_stack.append(curr_str)
                curr_val=0
                curr_str=""

            elif i == "]":
                val=num_stack.pop()
                curr_str=curr_str*val
                curr_str=alph_stack.pop()+curr_str
                
            else:
            #Number can have multiple digits. for example 23 = 2*10+3
                curr_val=curr_val*10+int(i)
        return curr_str