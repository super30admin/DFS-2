// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: Idea is to group all connected ones together and see how many such groups exist.
// DFS helps to find all connected 1s, the ones that aren't visited during the traversal are not connected.
// Run DFS, whenever we visit a 1, we mark it as 0. Do the same for all 1s in matrix.
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        
    }
}

// Time Complexity : 
// Space Complexity : O(string length)
// Did this code successfully run on Leetcode : almost, failed for some test cases
// Any problem you faced while coding this : some test case if failing


// Your code here along with comments explaining your approach

class Solution {
    Stack<Integer> st;
    public String decodeString(String s) {
        st = new Stack<Integer>();
        return dfs(s);
    }
    public String dfs(String s){
        int i=0;
        StringBuilder res = new StringBuilder();
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                char c = s.charAt(i);
                int n = c - '0';
                i++;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    n = n*10;
                    n = n + (s.charAt(i)-'0');
                    i++;
                }
                st.push(n); // i will be '['
                int j=i+1;
                while(s.charAt(j)!=']'){
                    j++;
                }
                System.out.println("s.substring(i,j+1)" + s.substring(i,j+1));
                String inner = dfs(s.substring(i,j+1));
                System.out.println("inner "+inner);
                res.append(inner);
                i=j;
            }
            else if(s.charAt(i)=='['){
                res.append("");
            }
            else if(Character.isLetter(s.charAt(i))){
                res.append(s.charAt(i));
            }
            else if(s.charAt(i)==']'){
                int val = st.pop();
                System.out.println("val "+val);
                StringBuilder tmp = new StringBuilder(res);
                val--;
                while(val>0){
                    res.append(tmp);
                    val--;
                }
                break;
            }
            i++;
        }
        return res.toString();
    }
}
