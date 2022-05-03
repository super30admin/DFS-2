#decode string

# // Time Complexity :O(N) - N is the length of the output string
# // Space Complexity : O(B) - B is the number of open brackets in the string
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def decodeString( s):
    num_value=[]
    string_value=[]
    num=0
    string=""
    for i in s:
        if (i.isnumeric()):                                 #if the character is a number, then multiply the last number by 10 and add it to the current number
            num = num *10 + int(i)
            
        elif(i=='['):                                       #if its a open bracket, then add the current string and number to their stack and set them to empty and 0
            num_value.append(num)
            string_value.append(string)
            num=0
            string=""
            
        elif (i==']'):                                      #if its a closed bracket, then pop the value from the nums stack then multiply the current string that many times, then append the string value to that
            n=num_value.pop()
            s=string*n
            string = string_value.pop() + s
            
        else:                                               #if its a alphabet character, then just add it to the current string
            string+=i
    
    return string