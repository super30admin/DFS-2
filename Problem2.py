## Problem2 (https://leetcode.com/problems/decode-string/)

# Method1: Using stack with string
# M -- Length of decoded string
# N -- Length of Input String
# Time Complexity : O(M ^ 2) + O(M + N)
# O(M + N) -- O(N) -- for going through input string + length of the decoded string --- eg: 2[a1[b2[cf3[d]]]]2[y] -- K4 * (P3 + K3 * (P2 + K2*(P1 + K1 * S1)))
# Concatenating two strings can take at max O(M) -- so 1 + 2 + 3 + .... M -1 + M. So for M length decoded string = O(M ^ 2)
# Space Complexity : O(M + N) + O(M ^ 2)
# O(N) --- stack space + O(M) --- in worst case current string can become equal to decoded strin
# Concatenating two strings always creates a new string
# so at max O(M) -- so 1 + 2 + 3 + .... M -1 + M. So for M length decoded string SC = O(M ^ 2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We use two stacks here to keep track of parent string and Integer associated to the baby string. We use currNum to get the number and currStr to
# to maintain current string. When we hit a digit we do currNum = (10 * currNum) + currDigit. This helps to reduce the TC of getting the number
# part from the string to O(1). When we reach the opening bracket, it mean a new baby or new string has started.
# So we push the currStr and currNum into the parentStack and numStack reset the currStr and currNum. When we reach a closing bracket, we pop the number.
# We multiply it with the currStr to decode it. Then we pop the parent from the stack. We update the currStr = joining the 
# parent in front of the decoded string.

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        # to keep track of current string till we reach a integer
        currStr = ""
        # to keep track of number before '['
        currNum = 0
        # to keep track of parent string and integer factor till we reach ']'
        parentStack = []
        # to keep track of integer factor till we reach ']'
        numStack = []

        for i in range(len(s)):
            if(ord('0') <= ord(s[i]) <= ord('9')):
                # it is a digit
                # we need to form the integer that could of multiple digits
                currNum = (10 * currNum) + int(s[i])
            elif(s[i] == '['):
                # we also need to put the parent(string before the number) into the stack
                parentStack.append(currStr)
                currStr = ""
                # put the current number into the stack
                numStack.append(currNum)
                currNum = 0
            elif(s[i] == ']'):
                # it is a closing bracket
                # pop the number from the stack
                # decode the currStr based on popped number
                # make sure to make a copy of currStr
                # and do not directly append currStr to currStr
                num = numStack.pop()
                copyStr = ""
                for j in range(num):
                    # new string getting created each time
                    copyStr += currStr

                # now append it to the parent
                # new string getting created here as well
                currStr = parentStack.pop() + copyStr
            else:
                # it is a character
                currStr += s[i]
        
        return currStr
    
sol = Solution()
print("Method1: Using stack with string")
print(sol.decodeString("3[a]2[bc]"))
print(sol.decodeString("3[a2[c]]"))
print(sol.decodeString("2[abc]3[cd]ef"))
print(sol.decodeString("2[a1[b2[cf3[d]]]]2[y]"))


# Method2: Using stack with array
# M -- Length of decoded string
# N -- Length of Input String
# Time Complexity : O(M + N)
# O(M + N) -- O(N) -- for going through input string + length of the decoded string --- eg: 2[a1[b2[cf3[d]]]]2[y] -- K4 * (P3 + K3 * (P2 + K2*(P1 + K1 * S1)))
# Space Complexity : O(M + N)
# O(N) --- stack space + O(M) --- in worst case current string can become equal to decoded string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The logic is same as above. In place of string concatenation, we are using array to keep track of current string. So when merging parent with
# k * currString, we extend parent with currString and set currString to this updated parent whenever we reach a closing bracket. This helps to 
# reduce extra time and space complexity that was needed for string concatenation


class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        # to keep track of current string till we reach a integer
        currStr = []
        # to keep track of number before '['
        currNum = 0
        # to keep track of parent string and integer factor till we reach ']'
        parentStack = []
        # to keep track of integer factor till we reach ']'
        numStack = []

        for i in range(len(s)):
            if(ord('0') <= ord(s[i]) <= ord('9')):
                # it is a digit
                # we need to form the integer that could of multiple digits
                currNum = (10 * currNum) + int(s[i])
            elif(s[i] == '['):
                # we also need to put the parent(string before the number) into the stack
                parentStack.append(currStr)
                currStr = [] # creating a new path
                # put the current number into the stack
                numStack.append(currNum)
                currNum = 0
            elif(s[i] == ']'):
                # it is a closing bracket
                # pop the number from the stack
                # decode the currStr based on popped number
                # make sure to make a copy of currStr
                # and do not directly append currStr to currStr
                num = numStack.pop()
                parent = parentStack.pop()
                
                for j in range(num): # O(num*len(currStr))
                    parent.extend(currStr)
                
                currStr = parent # pointer moved to parent 
            else:
                # it is a character
                currStr.append(s[i])
        
        # print(currStr)
        return "".join(currStr)
    
sol = Solution()
print("Method2: Using stack with array")
print(sol.decodeString("3[a]2[bc]"))
print(sol.decodeString("3[a2[c]]"))
print(sol.decodeString("2[abc]3[cd]ef"))
print(sol.decodeString("2[a1[b2[cf3[d]]]]2[y]"))


# Method2: Using recursion
# M -- Length of decoded string
# N -- Length of Input String
# Time Complexity : O(M + N)
# O(M + N) -- O(N) -- for going through input string + length of the decoded string --- eg: 2[a1[b2[cf3[d]]]]2[y] -- K4 * (P3 + K3 * (P2 + K2*(P1 + K1 * S1)))
# Space Complexity : O(M + N)
# O(N) --- recursive stack space = max depth of the tree + O(M) --- in worst case current string can become equal to decoded string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# As we are doing DFS, it can be done using recursion as well. In place of numStack and parentStack we use the recursive stack to return the
# deepest child. When we encounter an opening bracket we recurse deep to get the deeper child and then we decode that child and append 4
# it with the parent. We keep going one level up at a time and repeating the same process. On closing bracket, it means the child has finished. 
# So we return the child to the parent


class Solution(object):
    def __init__(self):
        self.index = 0
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        # using recursion
        def helper(s):
            currNum = 0
            currStr = []
            while(self.index < len(s)):
                if(ord('0') <= ord(s[self.index]) <= ord('9')):
                    # if character is a digit
                    currNum = (currNum * 10) + int(s[self.index])
                    self.index += 1

                elif(s[self.index] == '['):
                    self.index += 1
                    # new child starts, append parent to parentStack and number to numStack
                    # also reset the currStr and currNum
                    # recurse
                    newStr = helper(s)
                    # decode and merge it with parent
                    for i in range(currNum):
                        # currStr would be our parent of newStr
                        currStr.extend(newStr)

                    # since it has been used reset it
                    currNum = 0

                elif(s[self.index] == ']'):
                    # current child finishes
                    # return the child list to the parent
                    self.index += 1
                    return currStr
                else:
                    # it is a character
                    currStr.append(s[self.index])
                    self.index += 1

            return currStr
        
        self.index = 0
        currStr = helper(s)
        return "".join(currStr)
    
sol = Solution()
print("Method3: Using recursion")
print(sol.decodeString("3[a]2[bc]"))
print(sol.decodeString("3[a2[c]]"))
print(sol.decodeString("2[abc]3[cd]ef"))
print(sol.decodeString("2[a1[b2[cf3[d]]]]2[y]"))
