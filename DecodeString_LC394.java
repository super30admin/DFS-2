// T: O(n) - maxK*n
// where n = length of given striing; maxk = max digit
// S: O(no of digits + no of aphabets) -> O(n)
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        
        
        int num = 0;
        StringBuilder str = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '['){
                strSt.push(str);
                numSt.push(num);
                str =  new StringBuilder();
                num = 0;
            }
            else if(c == ']'){
                StringBuilder result = new StringBuilder();
                result = strSt.pop();
                int n = numSt.pop();
                for(int i = 0; i < n; i++){
                    result.append(str);
                }
                str = result;
            }
            else if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            else if(Character.isAlphabetic(c)){
                str.append(c);
            }
        }
        return str.toString();
    }
}


//recursive
class Solution2 {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        int num = 0;
        StringBuilder str = new StringBuilder();
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '['){
                i++;
                String inner = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                while(num > 0){
                    newStr.append(inner);
                    num--;
                }
                str.append(newStr);
                num = 0;
            }
            else if(c == ']'){
                i++;
                return str.toString(); 
            }
            else if(Character.isDigit(c)){
                i++;
                num = num*10 + c - '0';
            }
            else if(Character.isAlphabetic(c)){
                i++;
                str.append(c);
            }
        }
        return str.toString();
    }
}