#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Dec 27 09:34:38 2019

@author: tanvirkaur
"""

# Time complexity: O(n)
 # Space complexity: O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        numstack =[]
        strstack = []
        curnum = 0
        curstr = ''
        newstring = ''
        for c in s:
            if c.isdigit():
                curnum = curnum*10 + int(c)
            elif c == '[':
                numstack.append(curnum)
                strstack.append(curstr)
                curnum = 0
                curstr = ''
                
            elif c == ']':
                times = numstack.pop()
                new_str = times * curstr
                curstr = strstack.pop()
                curstr += new_str
            else:
                curstr += c
        return curstr
        
        