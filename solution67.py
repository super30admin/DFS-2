#Time complexity:O(m*max(int))
#Space Complexity:O(n)

class Solution:
    i=0                                             #initializing i as global variable
    def decodeString(self, s: str) -> str:
        if len(s)==0:                               #if string is empty return string
            return s
        curStr=''                                   #initialize current string to be empty
        num=0                                       #initialize num to zero
        while self.i<len(s):                        #while i value remaqins less than the length of the string
            c=s[self.i]                             #c is the character of string at ith position
            if c.isnumeric():                       #if c is a number
                num=num*10+int(c)                   #calculate the total num value
                self.i+=1                           #increment i
            elif c=='[':                            #if i is an opening brace increment i by one and call a recursive call on the string for same i value
                self.i+=1
                inner=self.decodeString(s)
                for j in range(num):                # append the returned string to the currStr num number of times
                    curStr+=inner                   
                num=0                               #initialize num to zero
            elif c==']':                            #if c is a closing brace
                self.i+=1                           #increment i
                return currStr                      #return the current string
            else:                                   #if c is an alphabet
                curStr+=c                           #append the alphabet to the curstring
                self.i+=1                           #increment the i value
        return curStr                               #return the current string