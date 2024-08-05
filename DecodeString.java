// Time Complexity : O(n+m)
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        String result = "";
        int n = s.length();
        int i = 0;
        while(i<n){
            char curr = s.charAt(i);
            if(curr == ']'){
                String temp = "";
                while(!st.isEmpty()){

                    int x = st.pop();
                    char value = (char)x ;
                    if(value == '[') break;
                    temp = value +temp;
                }
                int mul = st.pop();
                temp = temp.repeat(mul);
                //System.out.println(temp);
                int j = 0;
                int m = temp.length();
                while(j<m){
                    st.push((int)temp.charAt(j));
                    j++;
                }
                i++;
            }else{
                if(curr >=48 && curr <= 57){
                    String num = "";
                    while(curr >=48 && curr <= 57){
                        num = num + curr;
                        i++;
                        curr = s.charAt(i);
                    }
                    int numi = Integer.parseInt(num);
                    //System.out.println(numi);

                    st.push(numi);
                }else{
                    //System.out.println(curr);
                    st.push((int)curr);
                    i++;

                }
            }
            
        }
        while(!st.isEmpty()){
            int x = st.pop();
            result = (char) x + result;
        }

        return result;
    }
}
