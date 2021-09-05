//Time Complexity - O(m*n)
//Space Complexity - O(m*n)
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int m=grid.size(),n=grid[0].size();
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            if(grid[i][j]=='1'){
                queue<pair<int,int>>q1;
                q1.push({i,j});
                grid[q1.front().first][q1.front().second]='2';
                while(!q1.empty()){
                    if(q1.front().first>0){
                        if(grid[q1.front().first-1][q1.front().second]=='1'){
                            q1.push({q1.front().first-1,q1.front().second});
                            grid[q1.front().first-1][q1.front().second]='2';
                        }
                    }
                    if(q1.front().first<m-1){
                        if(grid[q1.front().first+1][q1.front().second]=='1'){
                            q1.push({q1.front().first+1,q1.front().second});
                            grid[q1.front().first+1][q1.front().second]='2';
                        }
                    }
                    if(q1.front().second>0){
                        if(grid[q1.front().first][q1.front().second-1]=='1'){
                            q1.push({q1.front().first,q1.front().second-1});
                            grid[q1.front().first][q1.front().second-1]='2';
                        }
                    }
                    if(q1.front().second<n-1){
                        if(grid[q1.front().first][q1.front().second+1]=='1'){
                            q1.push({q1.front().first,q1.front().second+1});
                            grid[q1.front().first][q1.front().second+1]='2';
                        }
                    }
                    q1.pop();
                }
                ans++;
            }
            }
        }
        return ans;
    }
};