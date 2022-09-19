/*
Time Complexity: O(M*N)
Space Complexity: O(M*N)
*/
public class Solution {
  // define the 4 directions for dfs
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  
  public int numIslands(char[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0) 
      return 0;
        
    int n = a.length, m = a[0].length, mark = 1;
    
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (a[i][j] == '1')
          // found '1', let's mark it as ++mark
          dfs(a, n, m, i, j, ++mark);
    
    // return how many islands have been marked
    return mark - 1;
  }
  
  void dfs(char[][] a, int n, int m, int i, int j, int mark) {
    if (i < 0 || i >= n || j < 0 || j >= m || a[i][j] != '1') 
      return;
    
    a[i][j] = (char)('0' + mark);
    
    // dfs in 4 directions
    for (int k = 0; k < 4; k++)
      dfs(a, n, m, i + dx[k], j + dy[k], mark);
  }

}
