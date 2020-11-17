// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have 2 stacks one for number, one for string
and curr string to return
loop each element of string
if its a number then loop again till we get all numbers and finally append it to the number stack
else if its [ then append the curr to stack and reset curr to ""
else if its ] then pop number and string from stack and repeat curr popped number times and append popped string to it finally append all to curr
else if its a alphabet then cppend to curr
*/
package main

import "fmt"

func decodeString(s string) string {
	stNum := []int{}
	stStr := []string{}
	curr := ""
	x := 0
	for x<len(s) {
		if s[x] >= '0' && s[x] <= '9' {
			num :=0
			for x<len(s) && s[x] >= '0' && s[x] <= '9' {
				num = num * 10 + int(s[x] - '0')
				x++
			}
			stNum = append(stNum, num)
		} else if s[x] == '[' {
			stStr = append(stStr, curr)
			curr = ""
			x++
		} else if s[x] == ']' {
			currString := stStr[len(stStr) - 1]
			stStr = stStr[:len(stStr) - 1]

			currCount := stNum[len(stNum) - 1]
			stNum = stNum[:len(stNum) - 1]

			finStr := ""
			for y:=0;y<currCount;y++{
				finStr += curr
			}
			curr = currString + finStr
			x++
		} else {
			curr+=string(s[x])
			x++
		}
	}
	return curr
}

func MainDecodeString() {
	fmt.Println(decodeString("3[a]2[bc]")) //expected aaabcbc
}
