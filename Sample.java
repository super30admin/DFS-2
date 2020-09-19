// Problem 1 - Number of Islands
// Time Complexity : O(n*m + n*m) where n = number of rows and m = number of columns
// Space Complexity : O(n * m) -> extra space for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - loop through the grid
// 2 - when encountered 1, perform dfs
// 3 - convert the element to 0
// 4 - loop through directions
// 5 - get rowth and colth
// 6 - check for extreme cases and if the elemnt at that position is 1
// 7 - perform dfs
// 8 - once dfs is done, increase the count for islands
class Solution {
  private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int count = 0;
    // 1
    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[0].length; j++) {
        // 2
        if (grid[i][j] == '1') {
          recurr(grid, i, j);
          // 8
          count += 1;
        }
      }
    }

    return count;
  }

  private void recurr(char[][] grid, int i, int j) {
    // 3
    grid[i][j] = '0';
    // 4
    for (int[] dir : dirs) {
      // 5
      int r = dir[0] + i;
      int c = dir[1] + j;
      // 6
      if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
        // 7
        recurr(grid, r, c);
      }
    }
  }
}

// Problem 2 - Decode String
// Time Complexity : O(n + sum of integers)
// Space Complexity : O(n) -> extra space taken by 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze 2 stacks and a string and integer
// 2 - loop through the input string
// 3 - if char at ith position is digit, calculate the num
// 4 - if char is '[', push the num to num stack, push str to string stack and reset both the variables
// 5 - if char is ']', pop from num stack, get the current str appended popped number of times. and then append the popped string from str stack to this string
// 6 - else keep appending the character to current string
class Solution {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    // 1
    Stack<String> strStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();

    String str = "";
    int num = 0;
    // 2
    for (int i=0; i<s.length(); i++) {
      char ch = s.charAt(i);
      // 3
      if (Character.isDigit(ch)) {
        num = num * 10 + (ch - '0');
      } else if (ch == '[') { // 4
        numStack.push(num);
        strStack.push(str);
        num = 0;
        str = "";
      } else if (ch == ']') { // 5
        int poppedNum = numStack.pop();
        String temp = "";
        for (int j=0; j<poppedNum; j++) {
          temp += str;
        }

        str = strStack.pop() + temp;
      } else { // 6
        str += ch;
      }
    }

    return str;
  }
}
