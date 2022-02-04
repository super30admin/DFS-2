# DFS-2

## Problem1 (https://leetcode.com/problems/number-of-islands/)

# Time Complexity=O(M*N)
# Space Complexity=O(min(M,N))

class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;

    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          grid[r][c] = '0'; // mark as visited
          Queue<Integer> neighbors = new LinkedList<>();
          neighbors.add(r * nc + c);
          while (!neighbors.isEmpty()) {
            int id = neighbors.remove();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              neighbors.add((row-1) * nc + col);
              grid[row-1][col] = '0';
            }
            if (row + 1 < nr && grid[row+1][col] == '1') {
              neighbors.add((row+1) * nc + col);
              grid[row+1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              neighbors.add(row * nc + col-1);
              grid[row][col-1] = '0';
            }
            if (col + 1 < nc && grid[row][col+1] == '1') {
              neighbors.add(row * nc + col+1);
              grid[row][col+1] = '0';
            }
          }
        }
      }
    }

    return num_islands;
  }
}


## Problem2 (https://leetcode.com/problems/decode-string/)


# Time Complexity=O(Nk)
# Space Complexity=O(m+n)
class Solution:
    def decodeString(self, s: str) -> str:
        s1=[]
        s2=[]
        cs=""
        cn=0
        for i in s:
            if i.isnumeric():
                cn=cn*10+int(i)
            elif i=='[':
                s1.append(cs)
                s2.append(cn)
                cs=""
                cn=0
            elif i==']':
                k=s2.pop()
                temp=cs*k
                cs=s1.pop()+temp
            else:
                cs=cs+i
        return cs
            