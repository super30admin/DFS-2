import java.util.*;
public class DFS{
    // Time Complexity : M*N
    // Space Complexity : M*N
    // Did this code successfully run on Leetcode : yes 
    // Any problem you faced while coding this : no
    static int island;
    static int m;
    static int n;
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};;
    public int numIslandsDFS(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]=='1'){
                    island++;
                    dfs(grid,i,j);
                }
                
            }
        }
        return island;
    }
    public static void dfs(char[][] grid,int i, int j){
        if(grid[i][j] =='0' || i==m || j==m || i<0 || j<0){
            return;
        }
        grid[i][j]='0';
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j + dir[1];
            dfs(grid,r,c);
        }

    }
    //using bfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int island = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]=='1'){
                    island++;
                    grid[i][j]=0;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int r = curr[0]+dir[0];
                            int c = curr[1]+dir[1];
                            if(r<m && r>=0 && c<n && c>=0 && grid[r][c]=='1'){
                                grid[r][c]=0;
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return island;
    }

    // Time Complexity : N
    // Space Complexity : amount of nestings 
    // Did this code successfully run on Leetcode : yes 
    // Any problem you faced while coding this : no
    int i =0;
    public String decodeString(String s) {        
        if(s.length()== 0 || s == null) return s;
        
        int num = 0;
        
        StringBuilder currst = new StringBuilder();
        while(i<s.length()){
         char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 +c -'0';
                i++;
            }else if(c == '['){
                i++;
                String decoded = decodeString(s);
                StringBuilder newstr = new StringBuilder();
                for(int k =0;k<num;k++){
                    newstr.append(decoded);
                }
                currst.append(newstr);
                num=0;
            
            }else if(c == ']'){
                i++;
                return currst.toString();
           
            }else{
                currst.append(c);
                i++;
            }
        }
        return currst.toString();
        
        
        
    }
}