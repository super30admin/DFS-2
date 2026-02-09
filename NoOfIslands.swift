//
//  NoOfIslands.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/23/26.
//

/*
 Whenever we reach an island, all the connected ones becomes zero.
 BFS - when we find 1, then add it to the queue.
 Both BFS and DFS - time compelxty - O(m n), space complexity - O(mn)
 
 /*
  count islands -> start BFS from each node if the value is 1. Keep on adding the elements if it's 1. Change it to 0.
  worst case - 2(mn)
  */
If BFS is flowing right and top direction then it will be forming a diagonal. space is min(m, n) because the diagonal elements +- 1 will be present in the queue.
 
 time compelxity -> O(mn)
 Whne BFS flows in all four diretions -> mn/4
 whenever we are addingin the queue then change the state from 1 to 0.
 */

/*
 With DFS, time compelxity -> O(mn). Whereever we find 1, whenevreve we visited, we will mark it 0.
 Space - worst case scenartion - m*n recurive call under the hood.
 But BFS - space is min(m, n)
 */

class NoOfIslands {
    
    class QueueUsingLinkedList<T> {
        private class LinkedListNode<T> {
            var value: T
            var next: LinkedListNode<T>?
            init(value: T) {
                self.value = value
            }
        }

        private var front: LinkedListNode<T>?
        private var rear: LinkedListNode<T>?

        private var count: Int = 0

        func enqueue(_ val: T) {
            let newNode = LinkedListNode(value: val)
            if (front == nil) {
                front = newNode
                rear = newNode
            } else {
               rear?.next = newNode
               rear = newNode
            }
            count += 1
        }

        func dequeue() -> T? {
            if (front == nil) {
                return nil
            }

            let value = front?.value
            front = front?.next
            if (front == nil) {
                rear = nil
            }
            count -= 1
            return value
        }

        var isEmpty: Bool {
            return count == 0
        }

        var size: Int {
            return count
        }
    }
    
    //BFS
    /*
     time complexity - O(2mn) - O(m * n) - for all 1's, bfs will be done only once. Outer for loop will touch it again. So, in worst case, every node is being touched twice.
     Space complexity - min(m, n) only diagonal elements will be present at most in the queue.. Length of the diagonal.
     If the BFS is flowing right and down only, then it  will form diagonal. min(m, n) - diagonal +- 1 because 1 elemtn from the revious level can be present.
     If bFS flows in all 4 directions then mn/4
     */
    func numIslands(_ grid: [[Character]]) -> Int {
        var grid = grid
        var noOfIslands = 0
        let m = grid.count
        let n = grid[0].count
        for i in 0..<m {
            for j in 0..<n {
                if (grid[i][j] == "1") {
                    //start bfs from here, enqueue all the connected lands to it
                    var queue = QueueUsingLinkedList<(Int, Int)>()
                    noOfIslands += 1
                    queue.enqueue((i, j))
                    grid[i][j] = "0"
                    while (!queue.isEmpty) {
                        guard let (r, c) = queue.dequeue() else {
                            continue
                        }
                        var directions = [[1,0], [-1,0], [0,1], [0, -1]]
                        for dir in directions {
                            let newI = r + dir[0]
                            let newJ = c + dir[1]
                            if (newI < 0 || newJ < 0 || newI == grid.count || newJ == grid[0].count) {
                                continue
                            }
                            if (grid[newI][newJ] == "1") {
                                queue.enqueue((newI, newJ))
                                grid[newI][newJ] = "0"
                            }
                        }
                    }
                }
            }
        }
        return noOfIslands
    }
    
    //DFS
    /*
     Space complexity - in worst case, m*n recursive calls under the hood in recursion stack. BFS has min(m, n)
     time complexityt - O(2mn)
     */
    func noOfIslandsUsingDFS(_ grid: [[Character]]) -> Int {

        var grid = grid
        var noOfIslands = 0
        let m = grid.count
        let n = grid[0].count
        for i in 0..<m {
            for j in 0..<n {
                if (grid[i][j] == "1") {
                    //start bfs from here, enqueue all the connected lands to it
                    noOfIslands += 1
                    dfs(i: i, j: j, grid: &grid)
                }
            }
        }
        return noOfIslands
    }

    private func dfs(i: Int, j: Int, grid: inout [[Character]]) {
        //base
        if (i < 0 || j < 0 || i == grid.count || j == grid[0].count || grid[i][j] == "0") {
            return
        }

        //logic
        grid[i][j] = "0"
        let dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for dir in dirs {
            let newI = i + dir[0]
            let newJ = j + dir[1]
            //recurse
            dfs(i: newI, j: newJ, grid: &grid)
        }
    }
}

