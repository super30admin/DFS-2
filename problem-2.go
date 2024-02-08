/*time complexity = O(m*n)
space complexity = O(n)*/


/*package main

import (
	"strconv"
	"strings"
	"unicode"
)*/

func decodeString(s string) string {
	decoded := ""
	for _, char := range s{
		if char == ']'{
			decoded = decodeLast(decoded)
		}else{
			decoded += string(char)
		}
	}
	return decoded
}

func decodeLast(encoded string) string{
	start := strings.LastIndex(encoded, "[")
	sub := encoded[start+1:]
	end := start
	start--

	for start >= 0 && unicode.IsDigit(rune(encoded[start])){
		start--
	}

	rep, _ := strconv.Atoi(encoded[start+1: end])
	return encoded[:start+1] + strings.Repeat(sub, rep)
}
