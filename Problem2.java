// Time Complexity : O(maxK⋅n) K is max value in string
// Space Complexity : O(maxK⋅n) where k is max value in string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        Stack<String> t = new Stack();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while(!t.peek().contentEquals("["))
                    sb.append(t.pop());
                t.pop();
                
                int n = Integer.parseInt(t.pop());
                String a = sb.toString();
                sb.setLength(0);
                for(int j = 0; j < n; j++)
                    sb.append(a);
                t.push(sb.toString());
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i;
                while(s.charAt(j) >= '0' && s.charAt(j) <= '9')
                    j++;
                t.push(s.substring(i, j));
                i = j-1;
            } else
                t.push(s.substring(i, i+1));
        }
        StringBuilder ans = new StringBuilder();
        while(t.size() > 0)
            ans.append(t.pop());
        return ans.reverse().toString();
    }
}