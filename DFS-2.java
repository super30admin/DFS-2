//Time complexity O(maxK,N) and space complexity O(m+n)
class Solution {
    public String decodeString(String s) {

        //two stacks
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int num =0;

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num *10+s.charAt(i)-'0';

            }else if(s.charAt(i)=='['){
                numStack.add(num);
                strStack.add(currStr);
                num =0;
                currStr = new StringBuilder();

            }else if(s.charAt(i)==']'){
                int newNum = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k=0;k<newNum;k++){
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);

            }else{
                currStr.append(s.charAt(i));
            }
        }  

        return currStr.toString();      
    }
}

//Time complexity O(N) and space complexity O(min(N,M))
class Solution {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0) return 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    queue.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        for(int[] dir:dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                                
                                queue.add(new int[]{nr,nc});
                                grid[nr][nc]='0';
                            }
                        }
                    }
                }
            }
        }

        return count;
        
    }
}
