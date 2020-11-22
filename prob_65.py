# leet code -  394 - decode string
# Time -O(N) - N is length of the string
# space - O(N) - 2 stacks with total n numbe rof characters
#Algo : we iterate throught the string and have 4 cases when we encounter int, char, open brace and closed brace,
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        str_stk = []
        num_stk = []
        cur_str = ''  # initialising str
        cur_num = 0  # initialising num
        for i in s:
            if i.isdigit():  # .isaplha() gives string
                cur_num = cur_num * 10 + int(
                    i) #if the num repeats, that is if it is more than units digit then ---
            elif i == '[':  #we keep appending to reinitialise whenever we encounter '['
                num_stk.append(cur_num)
                str_stk.append(cur_str)
                cur_num = 0
                cur_str = ''
            elif i == ']':
                times = num_stk.pop()
                cur_str = times * (cur_str) #this case we multiply the numoftimes with what ever is in currstr
                cur_str = str_stk.pop() + cur_str #adding previously built string to the currone --- finally this will be returned at the end of the solution
            else:  # case when its is character
                cur_str = cur_str + i #if the char repeats then we add it to the existing string
        return cur_str





