class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> stringSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = (10*num) + c - '0'; 
            } else if (c == '['){
                numSt.push(num);
                stringSt.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']'){
                int times = numSt.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times; j++){
                    newStr.append(currStr);
                }
                // combine it with parent
                currStr = stringSt.pop().append(newStr);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

/*
Time complexity = O(N*K), where K is the max number of repetitios of a substring
Space Complexity = O(N)
*/