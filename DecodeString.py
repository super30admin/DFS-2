# Time Complexity : O(n) - We iterate through the string once, and for each character (including nested sections), the operations such as appending to the stack, popping, and joining take constant time.
# Space Complexity : O(n) - In the worst case, the stack can hold all characters from the input string, so space grows linearly with the input size
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for i in range(0,len(s)):
            if(s[i]!="]"):
                stack.append(s[i])
            else:
                #To add the strings together
                substr = ""
                while(stack[-1]!="["):
                    substr = stack.pop() + substr
                #We are sure as after above subproblem is done there would be [ to be popped
                stack.pop()
                #To add the digits together
                k = ""
                #By end of this loop the stack would be empty so check that base condition
                while(len(stack)>0 and stack[-1].isdigit()):
                    #Get the digits in form from string
                    k = stack.pop() + k
                #Multiply the string of digits converted to int with the previous sbstr
                stack.append(int(k) * substr)
        #"".join funciton allows a list of elements to get combined as a string
        return "".join(stack)