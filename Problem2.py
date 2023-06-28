#Time complexity is:O(n) where n is the maximum length of the string generated
#Space complexity is: O(m) where m is the length of the maximum output string
#Faced no issues while coding
#COde ran successfully on leetcode

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        #Initializing two stacks
        strSt=[]
        numSt=[]
        #Initializing cuurent string and number to 0
        currSt=""
        currNum=0
        #We will be iterating through each character in the string
        for i in range(0,len(s)):
            c=s[i]
            #If the character is a number, we will add that to currNum
            if(c.isdigit()):
                currNum=currNum*10 + int(c)
            #If the c is equal to [ we will currNum and currSt to the stacks 
            elif(c=='['):
                numSt.append(currNum)
                strSt.append(currSt)
                currSt=""
                currNum=0
            #If c is equal to ], we will repeat the currstr n times where n 
            #is the top most value in the stack and we will add that to the parent
            elif(c==']'):
                count=numSt.pop()
                newStr=""
                for k in range(count):
                    newStr+=currSt
                parent=strSt.pop()
                currSt=parent+newStr
            #Otherwise we will add the c to the currStr
            else:
                currSt+=c
        #Finally we are returning the currSt
        return currSt
