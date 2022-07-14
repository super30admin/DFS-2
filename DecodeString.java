// Time Complexity : O(maxk * n)
// Space Complexity : O(m+n) where m = [a-z] n = [0-9]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class DecodeString {
    int i=0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        String temp = "";
        while(i<s.length()) {
            char ch = s.charAt(i);
            i++;
            if(Character.isDigit(ch))
                count = count*10 + (ch-'0');
            else if(ch == '['){
                temp = decodeString(s);
                while(count>0) {
                    res.append(temp);
                    count--;
                }
                //System.out.println(res.toString());
            }else if(ch==']') {
                break;
            }else{
                res.append(ch);
            }
        }
        
        return res.toString();
        
    }
}
