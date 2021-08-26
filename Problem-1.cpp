/*
Time Complexity = O(M*N)
Space Complexity = O(M*N)
where M is the number of rows and N is the number of coloumns in the matrix.
*/
class Solution {
public:
    int m,n;
    void dfs(vector<vector<char>>& grid, int i, int j)
    {
        //base
        if(i<0 || i==m || j<0 || j==n || grid[i][j]=='0')
            return;
        
        //logic
        grid[i][j]='0';
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
    int numIslands(vector<vector<char>>& grid) {
        int i,j;
        m = grid.size();
        n = grid[0].size();
        int count=0;
        for(i=0;i<m;i++)
            for(j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {   count++;
                    dfs(grid, i, j);   
                }
            }
        return count;
    }
};

/*
Time Complexity = O(M*N)
Space Complexity = O(M*N)
where M is the number of rows and N is the number of coloumns in the matrix.
*/
class Solution {
public:
    int m,n;
    int numIslands(vector<vector<char>>& grid) {
        int i,j,k;
        m = grid.size();
        n = grid[0].size();
        vector<vector<int>> dir{{0,1},{1,0},{0,-1},{-1,0}};
        int count=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {   count++;
                    queue<vector<int>> q;
                    grid[i][j] = '0';
                    q.push({i,j});
                    while(!q.empty())
                    {
                        vector<int> temp(q.front());
                        q.pop();
                        for(k=0;k<4;k++)
                        {
                            int r = temp[0]+dir[k][0];
                            int c = temp[1]+dir[k][1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1') {
                                q.push({r,c});
                                grid[r][c]='0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
};
