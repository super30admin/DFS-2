// Time Complexity :O(mn)
// Space Complexity :min(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int count = 0;
        int [][] dirs = new int [][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                q.add(new int []{i,j});
                    grid[i][j] ='0';
                    count++;
            while(!q.isEmpty()){
            int [] curr = q.poll();
            for( int [] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length 
                   && nc <grid[0].length && grid[nr][nc] == '1'){
                    q.add(new int []{nr,nc});
                    grid[nr][nc] ='0';
                    }
                }   
            }
        }
    }
        
 }
   return count;     
        
        
}
}
// Time Complexity :length of decoded string
// Space Complexity :length of decoded string
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if(s == null ||s.length()== 0) return s;
        Stack<StringBuilder> strst = new Stack<>();
        Stack<Integer> inst = new Stack<>();
        int num =0;
        StringBuilder curr = new StringBuilder();
        for(int i = 0;i<s.length();i++){
           char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
            }else if( c == '['){
                strst.push(curr);
                inst.push(num);
                num = 0;
                curr = new StringBuilder();
            }else if(c == ']'){
                int k = inst.pop();
                StringBuilder child = new StringBuilder();
                for(int j = 0;j<k;j++){
                    child.append(curr);
                }
                //adding parent to child
                StringBuilder parent = strst.pop();
                parent.append(child);
                curr = parent;
            }
            else 
                curr.append(c);
        }
        return curr.toString();
    }
}
