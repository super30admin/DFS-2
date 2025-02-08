/*
TC : O (m*n)
SC : O (m*n)
*/
class Solution
{
public:
    int numIslands(vector<vector<char>> &grid)
    {
        if (grid.empty() || grid.size() == 0)
        {
            return 0;
        }

        queue<vector<int>> store;
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R
        int totalIsland = 0;
        int m = grid.size();
        int n = grid[0].size();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                // check if it's an 1 which is expected to be an island
                if (grid[i][j] == '1')
                {
                    grid[i][j] = 2;
                    store.push({i, j});
                    while (!store.empty())
                    {
                        vector<int> curr = store.front();
                        // check for the neighbours
                        for (int k = 0; k < dirs.size(); k++)
                        {
                            int nr = curr[0] + dirs[k][0];
                            int nc = curr[1] + dirs[k][1];
                            // check if not valid index and not visited
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1')
                            {
                                grid[nr][nc] = '2';
                                store.push({nr, nc});
                            }
                        }
                        store.pop();
                    }
                    totalIsland++;
                }
            }
        }

        return totalIsland;
    }
};