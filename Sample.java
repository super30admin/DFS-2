// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    
    private void dfs(int row,int col,char[][] grid){
        if( row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0'){
            return;
            
        }
        grid[row][col]='0';
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
    }
}




class Solution {
    public String decodeString(String s) {
        Stack<Integer> numstack=new Stack<>();
        Stack<StringBuilder> strstack=new Stack<>();
        int num=0;
        StringBuilder curString=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(Character.isDigit(temp)){
                num=num*10+(temp-'0');
                
            }
            else if(temp=='['){
                numstack.push(num);
                strstack.push(curString);
                num=0;
                curString=new StringBuilder();
                
                
            }
            else if(temp==']'){
                int times=numstack.pop();
                StringBuilder str=new StringBuilder();
                for(int k=0;k<times;k++){
                    str=str.append(curString);
                }
                curString=strstack.pop().append(str);
                
                
                
            }else{
                curString.append(temp);
            }
        }
        return curString.toString();
    }
}