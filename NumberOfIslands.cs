// Time Complexity : O(MN)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int NumIslands(char[][] grid) {
        var m  = grid.Length; var n = grid[0].Length;
        var dirs = new List<(int, int)> { (0,1), (0, -1), (-1, 0), (1,0)};
        var q = new Queue<(int Row, int Col)>();
        int count = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] =='1')
                {
                    count++;
                    q.Enqueue((i,j));
                    grid[i][j] = '0';
                    while(q.Count > 0){
                        var curr = q.Dequeue();
                        foreach(var dir in dirs)
                        {
                            var nr = curr.Row + dir.Item1;
                            var nc = curr.Col + dir.Item2;
                            if(nr >= 0 && nc >=0 && nr < m && nc < n && grid[nr][nc] == '1')
                            {                                
                                q.Enqueue((nr,nc));
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
