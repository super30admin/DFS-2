/**
 * time complexity O(maxK)*n
 * space complexity is O(n)
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList<>();
        for(char ch : s.toCharArray()) {
            q.offer(ch);
        }
        return helper(q);
    }
    
    private String helper(Queue<Character> queue) {
        int k = 0;
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            char ch = queue.poll();
            if(Character.isDigit(ch)) {
                k = k*10 + (ch - '0');
            }else if(Character.isAlphabetic(ch)) {
                sb.append(ch);
            }
            else if(ch == '[') {
                String s = helper(queue);
                for(int i = 0; i < k; i++) {
                    sb.append(s);
                }
                k = 0;
            }
            else if(ch == ']') {
                break;
            }
        }
        return sb.toString();
    }
}