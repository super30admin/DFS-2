from collections import deque
class Solution:
    def decodeString(self, s: str) -> str:
        if s is None or len(s) == 0:return s
        numebrstack=deque()
        stringstack=deque()
        currentnumber, currentword, counter, size = 0, '', 0, len(s)-1
        while counter < size:
            if s[counter].isdigit():
                tmp=int(s[counter])
                currentnumber=int(currentnumber)*10 + tmp - '0'


            elif s[counter]=='[':
                stringstack.append(currentword)
                numebrstack.append(currentnumber)
                currentnumber=0
                currentword=''


            elif s[counter] == ']':
                size=numebrstack.pop()
                word=''
                for id in range(size):
                    word=word+''+currentword

                currentword=stringstack.pop()+currentword


            else:
                currentword=currentword+s[counter]
        return currentword







if __name__ == '__main__':
    print(Solution().decodeString( s = "3[a]2[bc]"))