// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// problem 1

Iterative

class Solution {
    public String decodeString(String s) {
     if (s == null || s.length() == 0) return null;
     Stack<StringBuilder> strStack=new Stack<>();
     Stack<Integer> numStack=new Stack<>();
     int num=0;
     StringBuilder curStr= new StringBuilder();
     
    for(int i=0; i < s.length(); i++){
    
        char c=s.charAt(i);
        
        if (Character.isDigit(c)){
        
         num = num * 10 + c - '0';
                    
        }
        else if ( c == '[')
        {
          numStack.add(num);
          strStack.add(curStr);
          num =0;
          curStr = new StringBuilder();
        }
        else if ( c == ']')
        {
            int times = numStack.pop();
            
            StringBuilder newstr= new StringBuilder();
            
            for ( int j=0; j < times; j++)
            {
                newstr.append(curStr);
            }
            
            curStr=strStack.pop().append(newstr);
            
        }
        else
        {
           curStr.append(c); 
        }
        
        
    }
    
     return curStr.toString();   
     
        
    }
}


Recursive


class Solution {
    int i; 
    public String decodeString(String s) {
     if (s == null || s.length() == 0) return null;
     int num=0;
     StringBuilder curStr= new StringBuilder();
     
   while(i<s.length()){
    
        char c=s.charAt(i);
        
        if (Character.isDigit(c)){
        
         num = num * 10 + c - '0';
         
        i++;
                    
        }
        else if ( c == '[')
        {
          i++;
          String decoded=decodeString(s);
          StringBuilder newStr=new StringBuilder();
          for(int j=0; j<num; j++){
              newStr.append(decoded);
          }    
          curStr.append(newStr);
          num=0;
          
        }
        else if ( c == ']')
        {
            i++;
            return curStr.toString();
            
        }
        else
        {
           curStr.append(c); 
            i++;
        }
        
        
    }
    
     return curStr.toString();   
     
        
    }
}


//Problem 2

// bfs

//T.C O(m*n
//s.c min of M OR N

class Solution {
    public int numIslands(char[][] grid) {
     if (grid == null || grid.length == 0) return 0;
     int m = grid.length;
     int n = grid[0].length;
     int count=0;
     Queue<int []> q = new LinkedList<>();
     int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    
     for (int i=0; i<m; i++)
     {
         for (int j=0; j<n; j++)
         {
             if (grid[i][j] == '1'){
                 grid[i][j] = '0';
                 count++;
                 q.add(new int [] {i,j});
                 if(!q.isEmpty())
                 {
                   int[] curr=q.poll();
                   for(int[] dir: dirs)
                   {
                     int nr = curr[0]+dir[0];
                     int nc = curr[1]+dir[1];
                     if ( nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1' ){
                         grid[nr][nc] = '0';
                         q.add(new int[] {nr,nc});
                     }
                   }  
                     
                 }
        }
             
             
         }
     }
     
     return count;
        
    }
}
