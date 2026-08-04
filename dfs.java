//problem1
class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    grid[i][j]='0';
                    q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] dir:dirs){
                int nr=dir[0]+curr[0];
                int dr=dir[1]+curr[1];
                if(nr>=0 && dr>=0 && nr<m && dr<n && grid[nr][dr]=='1'){
                    q.add(new int[]{nr,dr});
                    grid[nr][dr]='0';
                }
            }
        }
                }
            }
    }
    return cnt;
}
}
//problem2
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numst=new Stack<>();
        Stack<StringBuilder> chst=new Stack<>();
        StringBuilder curr=new StringBuilder();
        int num=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+ch-'0';
            }else if(ch=='['){
                numst.push(num);
                chst.push(curr);
                num=0;
                curr=new StringBuilder();
            }else if(ch==']'){
                int cnt=numst.pop();
                StringBuilder sb=new StringBuilder();
                for(int k=0;k<cnt;k++){
                    sb.append(curr);
                }
                StringBuilder pa=chst.pop();
                pa.append(sb);
                curr=pa;
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
