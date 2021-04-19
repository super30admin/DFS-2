//time complexity: O(nk) n is length of the string and k is the biggest number in the string
//Space Complexity: O(nk) n is length of the string and k is the biggest number in the string
class Solution { 
    public String decodeString(String s) {
        String curr="";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            else if(c=='['){
                numStack.push(num);
                strStack.push(curr);
                num=0;
                curr="";
            }
            else if(c==']'){
                int n =numStack.pop();
                StringBuilder sb = new StringBuilder();
                String str= "";
                for(int k=0;k<n;k++){
                    //sb.append(curr);
                    str=str+curr;
                }
                curr=strStack.pop()+str;
            }
            else{
                curr=curr+c;
            }
        }
        return curr;
    }
}