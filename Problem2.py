# // Time Complexity : O(n) where  n is the size of the list
# // Space Complexity : O(n) where  n is the size of the list
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def decodeString(self, s: str) -> str:
        def getcompletedigit(s,index):
            result = ""
            while(s[index] != "["):
                result += s[index]
                index+= 1   
            return int(result), index
        
        def getDecodedString(s, index):
            if index >= len(s):
                return "",index
            result = ""
            i = index
            while(i < len(s)):
                ch = s[i]
                if ch.isalpha():
                    result += ch
                    i += 1
                if ch =="]":
                    return result, i+1
                if ch.isdigit():
                    count,i = getcompletedigit(s,i)
                    temp, newIndex = getDecodedString(s, i+1)
                    temp2 = count*temp
                    result += temp2
                    i = newIndex
            return result, -1
                    
        result,newIndex =  getDecodedString(s,0)
        return result
