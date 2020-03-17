// Time Complexity : O(N)
// Space Complexity : O(length of output string)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we have used two stacks to solve this problem.one for storing strings and another for digit.when we encounter [ we push the values to both the stacks and when it is ] we pop them out.if we get a character we append to the string and if it is digit we store it in num.when we reach the end of the string we will end up having the required decoded string.
#using two stacks
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s==None or len(s)==0:
            return ''
        numlist=[]
        strlist=[]
        str1=''
        str2=''
        num=0
        for i in s:
            if i.isdigit():
                num=int(i)+(num*10)
            elif i=='[':
                numlist.append(num)
                strlist.append(str1)
                num=0
                str1=''
            elif i==']':
                num1=numlist.pop()
                str1=str1*num1
                str1=strlist.pop()+str1
            else:
                str1=str1+i
        return str1


// Time Complexity : O(n)
// Space Complexity :O(length of output string)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we do this using one stack.we store the values of string and num in the stack when we encounter [ and then we pop to perform calculations we encounter ].if we encounter a character we then add it to the string and if we continue this process we end up having the decoded string.

#using single stack
class Solution(object):
    def __init__(self):
        self.i = 0
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        strlist = []
        num = 0
        while self.i < len(s):
            token=s[self.i]
            if token.isdigit():
                self.i=self.i+1
                num = int(token) + (num * 10)
            elif token == '[':
                self.i=self.i+1
                rem=self.decodeString(s)
                while (num>0):
                    strlist.append(rem)
                    num=num-1

            elif token == ']':
                self.i=self.i+1
                strlist=''.join(strlist)
                return strlist
            else:
                self.i=self.i+1
                strlist.append(token)
        return ''.join(strlist)


// Time Complexity : O(n)
// Space Complexity : O(length of output string)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
For this problem we use recursion.There are different characters we have to handle.if it is [ we call the function recursively.
if it is digit we store them in num and for character we store in strlist and for ] we return the list.we get the decoded string at the end of the list.


class Solution(object):
    def __init__(self):
        self.i = 0
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        strlist = []
        num = 0
        while self.i < len(s):
            token=s[self.i]
            if token.isdigit():
                self.i=self.i+1
                num = int(token) + (num * 10)
            elif token == '[':
                self.i=self.i+1
                rem=self.decodeString(s)
                while (num>0):
                    strlist.append(rem)
                    num=num-1

            elif token == ']':
                self.i=self.i+1
                strlist=''.join(strlist)
                return strlist
            else:
                self.i=self.i+1
                strlist.append(token)
        return ''.join(strlist)