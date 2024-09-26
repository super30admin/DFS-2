// Time Compelxity: O(m*n)
// Space Complexity: O(m*n)
class Solution {
    int count=0;
    int [][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        
        
        if(grid==null||grid.length==0)
            return 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
              if(grid[i][j]=='1')
              {
                  //System.out.println("Enter 1");
                  count++;
                  dfs(grid,i,j);
              }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int i,int j)
    {
        if(i>-1&&j>-1&&i<grid.length&&j<grid[i].length&&grid[i][j]=='1')
        {
             //System.out.println("Enter 2");
             grid[i][j]='0';
            for(int a=0;a<dirs.length;a++)
            {
                int r=i+dirs [a][0];
                int c=j+dirs[a][1];
                dfs(grid,r,c);
            }
        }
       
    }
}
------------------------------------------------------------------------------------------------------
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public String decodeString(String s) {
         Stack<Integer> numStack= new Stack();
        Stack<StringBuilder> worStack= new Stack();
        StringBuilder curStr=new StringBuilder();
        if(s==null)
            return "";
        int cnum=0;
        for(int i=0;i<s.length();i++)
        {  
          char c=s.charAt(i);
        //Case when number
        if(Character.isDigit(c))
        {
            cnum=cnum*10+c-'0';
        }
            
        //Case when open bracket
         else if(c=='[')
         {
            numStack.push(cnum);
            worStack.push(curStr);
            cnum=0;
            curStr=new StringBuilder();
         }
        //Case when closed bracket
            else if(c==']')
            {
                int itr=numStack.pop();
                StringBuilder ns= new StringBuilder();
                for(int j=0;j<itr;j++)
                {
                    ns.append(curStr);
                }
                StringBuilder prev= worStack.pop();
                curStr=prev.append(ns);
            }
        else
            curStr.append(c);
        }
        return curStr.toString();
    }
}