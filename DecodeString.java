// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class DecodeString {
	int index = 0, n;
    public String decodeString2(String s){
        if(null == s || 0 == s.length()){return "";}
        n = s.length();  
        return helper(s,new StringBuilder("")).toString();
    }
    public StringBuilder helper(String s, StringBuilder result){
        if(index >= n){
            return result;
        }
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(index < n && Character.isDigit(s.charAt(index))){
                    count = count*10 + s.charAt(index) - '0';
                    index++;
                }
                StringBuilder temp = helper(s,new StringBuilder(""));
                    for(int i = 0 ; i < count; i++){
                        result.append(temp);
                    }
                return result.append(helper(s,new StringBuilder("")));
            }else if('[' == s.charAt(index)){
                index++;
                return helper(s,result);
            }else if(']' == s.charAt(index)){
                index++;
                return result;
            }else{
                result.append(s.charAt(index));
                index++;
                return helper(s,result);
            }
    }
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder("");
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> resStack = new Stack<String>();
        int index = 0;
        while(index < s.length()){
            int count = 0;
            if(Character.isDigit(s.charAt(index))){
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    count = count*10 + s.charAt(index)-'0';
                    index++;
                }
                countStack.push(count);
            }else if(s.charAt(index) == '['){
                resStack.push(res.toString());
                res = new StringBuilder();
                index++;
            }else if(s.charAt(index) == ']'){
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp;
                index++;
            }else{
                res.append(s.charAt(index));
                index++;
            }
        }
    return res.toString();
    }
}