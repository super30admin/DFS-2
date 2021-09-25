// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//o(m*n) time and o(min(m,n)) space

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int m = grid.length; int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1} , {0,-1} , {-1,0}, {1,0}};
        Queue<int []> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == '1'){ //checking each node if we get 1
                    count++;            // increasing ocunt
                    grid[i][j] = '0';   //change it to  0
                    q.add(new int[] {i,j}); // add that to q
                    while(!q.isEmpty()){
                        int [] curr = q.poll();
                        for(int [] dir: dirs){   //loopoing over all 4 dirs
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r >= 0 && c >=0 && r<m &&c <n && grid[r][c] =='1' ){
                                grid[r][c] = '0';
                                q.add(new int [] {r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;

    }
}

//o(k) length of output time //o(number of square brackets) space

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder curr = new StringBuilder();
        int num = 0;
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                //push the num and parend string in stack
                str.push(curr);
                numSt.push(num);
                curr = new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                int times = numSt.pop();
                StringBuilder newStr = new StringBuilder();
                for(int g = 0; g < times; g++){
                    newStr.append(curr);

                }
                //append the baby to parent
                curr = str.pop().append(newStr);
            }
            else{
                curr.append(c);
            }
        }
        return curr.toString();

    }
}