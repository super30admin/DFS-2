package main

import "fmt"

// Time : O(N) : n is length on the output? // how; confusing
// Space : O(N) : n is output length
// TODO : do this with recursion next time.
func decodeString(s string) string {
	// stacks
	stringStack := []string{}
	numStack := []int{}

	currentString := ""
	currentNum := 0

	for i := 0; i < len(s); i++ {
		char := s[i]
		if string(char) == "[" {
			// push string to top of stack
			stringStack = append(stringStack, currentString)
			numStack = append(numStack, currentNum)
			currentNum = 0
			currentString = ""
		}
		if string(s[i]) == "]" {
			// operations
			// pop string stack
			topstringStack := stringStack[len(stringStack)-1]
			stringStack = stringStack[:len(stringStack)-1]
			// pop num stack
			topnumStack := numStack[len(numStack)-1]
			numStack = numStack[:len(numStack)-1]

			dString := ""
			for i := 0; i < topnumStack; i++ {
				dString = dString + currentString
			}

			currentString = topstringStack + dString
			currentNum = 0
		}
		if s[i] >= 48 && s[i] <= 57 { // its a number

			currentNum = currentNum*10 + int(char-'0')
			fmt.Println(currentNum)
		}
		if s[i] >= 97 && s[i] <= 122 { // its a char
			currentString = currentString + string(char)
		}
	}
	return currentString
}
