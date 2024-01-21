# Solution
# // Time Complexity : O(N) since we are going through the array once
# // Space Complexity : O(N) 3[a4[b5[c]]], in this case worst case will have 6 elements in numStack+charStack when N=12
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach1 is to use two stacks, one to keep hold of the string till then and then one stack to keep hold of the number once [ is
# hit. Similarly once ] is reached, pop the previous number, repeat current string previous number of times and we need to pop 
# the previous string and concatenate it with present repeated string.
# Approach2 is instead of using our stack, we can use recursion. Having a global index which can keep track of matrix will help in
# navigating the array properly between the recursions

# Recursion
i = 0
def decodeString(s):
    global i
    i = 0
    def helper(s):
        global i
        curStr = ""
        curNum = 0

        while i<len(s):
            if s[i].isnumeric():
                curNum = curNum*10 + int(s[i])
                i += 1
            elif s[i].isalpha():
                curStr += s[i]
                i += 1
            elif s[i] == "[":
                i += 1
                returnedStr = helper(s)
                toBeRetStr = ""
                while curNum > 0:
                    toBeRetStr += returnedStr
                    curNum -= 1
                curStr += toBeRetStr
            elif s[i] == "]":
                i += 1
                return curStr
        
        return curStr

    return helper(s)
                
    
    # Iterative
# def decodeString(s):
#     numStack = []
#     charStack = []
#     curStr = ""
#     curNum = 0

#     for c in s:
#         if c.isnumeric():
#             curNum = curNum*10 + int(c)
#         elif c.isalpha():
#             curStr += c
#         elif c == "[":
#             numStack.append(curNum)
#             charStack.append(curStr)
#             curNum = 0
#             curStr = ""
#         elif c == "]":
#             tempNum = numStack.pop()
#             tempCharStr = ""
#             while tempNum > 0:
#                 tempCharStr += curStr
#                 tempNum -= 1
#             curStr = charStack.pop() + tempCharStr
    
#     return curStr

if __name__ == "__main__":
    # s = "3[a]2[bc]"
    s = "3[a2[c]]"
    # s = "2[abc]3[cd]ef"
    # s = "100[leetcode]"
    print(decodeString(s))