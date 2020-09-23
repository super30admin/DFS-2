//Decode String
// Time Complexity :0(N)+ NO.of popped values
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0)
            return "";
        Stack<Integer> numstack= new Stack<>();
        Stack<String> strstack= new Stack<>();
            
        int currnum=0;
        String currstr="";
        
        for(int x=0;x<s.length();x++)
        {
            char ch=s.charAt(x);
            if(Character.isDigit(ch)){
                currnum=currnum*10+(ch-'0');
            }
            else if(ch=='[')
            {
                numstack.add(currnum);
                strstack.add(currstr);
                
                currnum=0;
                currstr="";
            }
            else if(ch==']')
            {
                int popInt=numstack.pop();
                String temp="";
                for(int i=0;i<popInt;i++){
                    temp+=currstr;
                }
                currstr=strstack.pop();
                currstr=currstr+temp;
            }
            else
                currstr+=ch;
            
        }
        return currstr;
    }
}
//Numbers of Islands
// Time Complexity :0(M*N)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    int[][] directions= {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        
        if(grid==null|| grid.length==0||grid[0].length==0)
            return 0;
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1'){
                    recurr(grid,i,j);
                    count+=1;
                }
            }
        }
        return count;
        
    }
    private void recurr(char[][] grid,int i, int j){
        grid[i][j]='0';
        for(int[] dirs:directions){
            int r=i+dirs[0];
            int c= j+dirs[1];
            
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1')
                recurr(grid,r,c);
        }
    }
}
