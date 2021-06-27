class Solution:
    """DFS Recursive Approach
    Time Complexity-O(n*k)
    Space Complexity-O(n*k)"""
    def __init__(self):
        self.i=0
    def decodeString(self, s: str) -> str:
        num=0
        string=""
        while self.i< len(s):
            if s[self.i].isdigit():
                num=int(s[self.i])+10*num
                self.i+=1
            elif s[self.i]=="[":
                newstr=""
                self.i+=1
                child=self.decodeString(s)
                for j in range(num):
                    newstr+=child
                string+=newstr
                num=0
            elif s[self.i]=="]":
                self.i+=1
                return string
            else:
                string+=s[self.i]
                self.i+=1
        return string
                
                
    """DFS Implementation Iterative approach
    Time complexity-O(n*k) where k is the maximum number of times any element has to repeat from thw given string and n is the number of elements
    Space Complexity-O(n*k)"""
    # def decodeString(self, s: str) -> str:
    #     num=0
    #     string=""
    #     numarr=[]
    #     stringarr=[]
    #     if not s:
    #         return ""
    #     for i in range(len(s)):
    #         if s[i].isdigit():
    #             num=int(s[i])+10*num
    #         elif s[i]=="[":
    #             numarr.append(num)
    #             stringarr.append(string)
    #             num=0
    #             string=""
    #         elif s[i]=="]":
    #             currstr=""
    #             numtimes=numarr.pop()
    #             for k in range(numtimes):
    #                 currstr+=string
    #             parent=stringarr.pop()
    #             parent+=currstr
    #             num=0
    #             string=parent
    #         else:
    #             string+=s[i]
    #     return string
                
                
                    
                
                
        