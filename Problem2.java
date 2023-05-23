// Time: O(n)
// Space O(n)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack();
        Stack<String> strings = new Stack();
        String res = "";
        int idx = 0;
        while(idx<s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int count = 0;
                while(Character.isDigit(s.charAt(idx))){
                    count = count*10 + (s.charAt(idx) -'0');
                    idx+=1;
                }
                nums.push(count);
            }else if(s.charAt(idx) == '['){
                strings.push(res);
                res = "";
                idx++;

            }else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder(strings.pop());
                int count = nums.pop();
                for(int i=0 ; i< count; i++){
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }else{
                res = res+ s.charAt(idx);
                idx++;
            }
        }
        return res;

    }

}