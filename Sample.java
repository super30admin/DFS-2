//Problem 1
// Time Complexity :O(n*m)
// Space Complexity :O(n+m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
        {
            return 0;

        }
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int dirs[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                { count++;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j]='2';
                    while(!q.isEmpty())
                    {
int cur[]=q.poll();
for(int dir[]:dirs)
{
    int nr=cur[0]+dir[0];
    int nc=cur[1]+dir[1];
    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1')
    {
        q.add(new int[]{nr,nc});
        grid[nr][nc]='2';
    }
}
                    }
                }
            }
        }
        return count;
    }
}
//Problem 2
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0)
        {
            return "";
        }
        Stack<StringBuilder> strStack=new Stack<>();
        Stack<Integer> numStack=new Stack<>();
        int num=0;
        StringBuilder cur= new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
num=num*10+(c-'0');
            }
            else if(c=='[')
            {
numStack.push(num);
strStack.push(cur);
num=0;
cur=new StringBuilder();
            }
            else if(c==']')
            {
int times=numStack.pop();
StringBuilder newStr=new StringBuilder();
for(int j=0;j<times;j++)
{
    newStr.append(cur);
}
cur=strStack.pop().append(newStr);
            }
            else{
cur.append(c);
            }
        }
        return cur.toString();
    }
}