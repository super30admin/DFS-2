# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No

class Solution {

    private int counter = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int k = 0;
        while(counter < s.length()){
            char token = s.charAt(counter);

            if(token >= '0' && token <= '9'){
                counter++;
                k = k * 10 + token - '0';
            }

            else if(token == '['){
                counter++;
                String newResult = decodeString(s);
                while(k > 0){
                    result.append(newResult);
                    k--;
                }
            }
             else if(token == ']'){
                 counter++;
                 return result.toString();
             }

            else{
                counter++;
                result.append(token);
            }

            }
              return result.toString();

    }
}