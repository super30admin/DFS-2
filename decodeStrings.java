//Time Complexity:O(N)
//Space Complexity:O(N)
//In this problem, I'll have a string builder to form my output string. I'll have a num string to keep track of the integers in the given string. I'll then check if it s alphabet and append it to sb. I'll also check for Integer and append it to num. I'll then check if it is the opening of the square bracket and increment the position and call the function recursivel, to find the next element. After that, I'll append that element to the output string, for as many times as the values in the num string. I'll then make num empty and move the pointer until I meet the closing square brackets. At, the end I'll be returning the string.
//This solution was executed successfully and got accepted in leetcode.
class Solution {
    int pos=0;
    public String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        String num="";
        for(int i=pos;i<s.length();i++){
            if(s.charAt(i)!='['&&s.charAt(i)!=']'&&!Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            else if(Character.isDigit(s.charAt(i))){
                num+=s.charAt(i);
            }
            else if(s.charAt(i)=='['){
                pos=i+1;
                String next=decodeString(s);
                for(int j=Integer.valueOf(num);j>0;j--){
                    sb.append(next);
                }
                num="";
                i=pos;
            }
            else if(s.charAt(i)==']'){
                pos=i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}