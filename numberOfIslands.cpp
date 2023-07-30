// Time Complexity :O(mxn)
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

//BFS approach and mutating the matrix to avoid repetition
// Your code here along with comments explaining your approach
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {

        vector<vector<int>> dirs = {{-1,0},{0,-1},{1,0},{0,1}};


        queue<vector<int>> q;
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    grid[i][j]='0';
                     
                    q.push({i,j});

                    while(!q.empty()){

                        int size = q.size();
                        for(int i=0;i<size;i++){
                            vector<int> curr = q.front();
                            q.pop();
                            for(vector<int> dir:dirs){
                                int nr = curr[0]+dir[0];
                                int nc = curr[1]+dir[1];

                                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){

                                    q.push({nr,nc});
                                    
                                    grid[nr][nc]='0';



                                }
                            }
                        }

                        
                    }

                }

            }
        }

        return count;

        
    }
};