# // Time Complexity : O(N) --> length of decoded string
# // Space Complexity : O(N) --> length of decoded string 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

## this is a tricky question. we should go to the innermost string and deode and decode it outwards.
## we check 4 cases of a character, digit, string, [ and  ]. we basically also have 2 stacks. one for numbers and one for strings.
## we calculate the number of as long as it is a digit and keep appending the character as long as we get it. when we encounter
## "[" we abandon the parent in the stack and go to baby. parent is basically the number and string and baby is the nested stuff. 
## then we rest the currNum and currStr. now if we encounter a "]" we have processed the baby. so we have a currStr , we pop the num from numStack 
## and multiply our currString with the num out of the stack. and then we pop our parent string and e=append this result to our parent string.
## make our parent as curr Str
class solution:

    def decode(self,s ):

        currNum = 0
        currStr= "" 
        numStack = []
        strStack = []

        for i in range(len(s)):

            if s[i].isdigit():
                currNum = currNum*10 + int(s[i])
            elif s[i] == "[":
                numStack.append(currNum)
                strStack.append(currStr)
                currNum = 0
                currStr = ""
            elif s[i] == "]":
                count = numStack.pop()
                child = currStr
                child = child * count

                parent_str = strStack.pop()
                parent_str += child

                currStr= parent_str
                
            else:
                currStr.append(s[i])
        
        return currStr
    
    ## In the recursive approach, we have a gobal variable i which keeps moving. we have our characters and accordingly we make changes. 
    ## if it is a digit we store it in our currNum(we reinitialize it for every recursive call) if it is a character we store it in currStr(
    # we reinitialize it in every recursive call and update i++. if we find a "[" we update i++ and the recursively call the string.
    ## when we get the "]" we increment i++ and return currStr. we get the returned currStr as a child. we get the child as child*currNUm
    ## and append it to currStr which is the parent and make our currNUm as 0.
    i= 0
    def decode_recursive(self, s):



        ##logic
        currStr = ""
        currNum = ""

        
        while self.i < len(s):

            if s[self.i].isdigit():
                currNum = currNum*10 + int(s[i])
                i+=1
            elif s[self.i]== "[":
                self.i+=1
                child = self.decode(s)
                child = child*currNum
                currStr+= child
                currNum = 0
            elif s[self.i] == "]":
                self.i+=1
                return currStr


            else:
                currStr += s[self.i]
                self.i+=1
        return currStr