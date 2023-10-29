//BFS Approach
//Time - O(mxn)+O(mxn) = 2(O(mxn)) = O(mxn)
//Space = min(m,n) because at max we will be doing bfs till the minimum of m or n, once we run a bfs at first one,
 then we will never iterate over it again.
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size()==0)return 0;
        int m = grid.size();
        int n = grid[0].size();
        queue<int> q;
        int count = 0;
        int dir[4][2]= {{0,-1}, {0,1}, {1,0}, {-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.push(i);
                    q.push(j);
                    grid[i][j] = '0';
                    while(!q.empty()){
                        int cr = q.front();
                        q.pop();
                        int cc =q.front();
                        q.pop();
                        for(int k=0;k<4;k++){
                            int nr = dir[k][0] + cr;
                            int nc = dir[k][1] + cc;
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){                    
                                q.push(nr);
                                q.push(nc);
                                grid[nr][nc] = '0';

                            }
                        } 
                    }

                }
            }
        } 
        return count;
        
    }
};
