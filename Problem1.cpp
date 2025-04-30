// Time Complexity : O(N*M) . 
// Space Complexity : O(N*M) 
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Traverse grid if we found "1" add to queue and perform bfs.
// 2. while performing bfs search for neighbours with '1' add its row and column to queue and convert to '0'.
// 3. Increase count if we get '1' while traversing grid and return at last.

class Solution {
public:
    int m,n;
    void bfs(vector<vector<char>>& grid, pair<int,int> t){
        queue<pair<int,int>> q;
        q.push(t);grid[t.first][t.second]=0;
        while(!q.empty()){
            int ii=q.front().first;
            int jj=q.front().second;
            //cout<<ii<<' '<<jj<<'\n';
            q.pop();
            if(ii>0 && grid[ii-1][jj]!='0'){
                grid[ii-1][jj]='0';q.push(make_pair(ii-1,jj));
            }
            if(ii<n-1 && grid[ii+1][jj]!='0'){
                grid[ii+1][jj]='0';q.push(make_pair(ii+1,jj));
            }
            if(jj<m-1 && grid[ii][jj+1]!='0'){
                grid[ii][jj+1]='0';q.push(make_pair(ii,jj+1));
            }
            if(jj>0 && grid[ii][jj-1]!='0'){
                grid[ii][jj-1]='0';q.push(make_pair(ii,jj-1));
            }
        }
    }
    
    int numIslands(vector<vector<char>>& grid) {
        n=grid.size();
        m=grid[0].size();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,make_pair(i,j));ans++;
                }
            }
        }
        return ans;
    }
};
