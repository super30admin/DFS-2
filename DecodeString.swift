//
//  DecodeString.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/29/26.
//

class DecodeString {
    private class StackUsingLL<T> {
        private class LinkedListNode<T> {
            var value: T
            var next: LinkedListNode<T>?
            init(value: T) {
                self.value = value
            }
        }

        private var head: LinkedListNode<T>?

        func push(val: T) {
            let newNode = LinkedListNode(value: val)
            if (head == nil) {
                //empty LinkedList
                head = newNode
                return
            }

            newNode.next = head
            head = newNode
        }

        func pop() -> T? {
            if (head == nil) {
                //ll is empty
                return nil
            }
            let value = head?.value
            head = head?.next
            return value
        }
    }
    
    /*
     cna be done iteratively using stack.
     can be done recursively using DFS
     
     String -
     
     DFS pattern completely
     time complexity -> (multiplication of all counts * length of the string) or the length of the output
     Space compelxity ->(multiplication of all counts * length of the string) or the length of the output
     
     */

    //time complexity - 100[a 100[b]] -> 10,000b. (multiplication of all counts * length of the string)
    //space complexity - (multiplication of all counts * length of the string)
    func decodeString(_ s: String) -> String {
        
        var parentStack = StackUsingLL<String>()
        var childCountStack = StackUsingLL<Int>()
        var currentCount: Int = 0
        var currentStr: String = ""

        for i in 0..<s.count {
            let charIndex = s.index(s.startIndex, offsetBy: i)
            let char = s[charIndex]
            if (char == "[") {
                parentStack.push(val: currentStr)
                childCountStack.push(val: currentCount)
                currentStr = ""
                currentCount = 0
            } else if (char == "]") {
                let childRepeatitionCount: Int = childCountStack.pop() ?? 0
                var babyString = ""
                for r in 0..<childRepeatitionCount {
                    babyString += currentStr
                }
                let parent = parentStack.pop()!
                currentStr = parent + babyString
            } else if (char.isNumber) {
                currentCount = currentCount * 10 + Int(String(char))!
            } else {
                currentStr.append(char)
            }
        }
        return currentStr
    }
    
    //MARK: decode string using recursion
    var i = 0
    func decodeStringUsingRecursion(_ s: String) -> String {
        var currentStr = ""
        var currentCount = 0

        while (i < s.count) {
            let charIndex = s.index(s.startIndex, offsetBy: i)
            let char = s[charIndex]
            if (char == "[") {
                i += 1
                let decodedBaby = decodeString(s)
                //repeat this baby for the currentCount no of times
                for k in 0..<currentCount {
                    currentStr += decodedBaby
                }
                currentCount = 0
            } else if (char == "]") {
                i += 1
                return currentStr
            } else if char.isNumber {
                currentCount = currentCount * 10 + Int(String(char))!
                i += 1
            } else {
                currentStr.append(char)
                i += 1
            }
        }
        return currentStr

    }
}
