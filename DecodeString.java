//https://leetcode.com/problems/decode-string/solutions/1016302/using-queue-and-dfs
class Solution {
    public String decodeString(String s) {
        Queue<Character> q = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            q.offer(c);
        }
        return dfs(q);
    }
    public String dfs(Queue<Character> q){
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }
            else if(c == '['){
                sb.append(dfs(q).repeat(num));
                num = 0;
            }
            else{
                if(c >= 'a' && c <= 'z') sb.append(c);
                
                if(c == ']') break;
            }
        }
        return sb.toString();
    }
}