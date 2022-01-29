//Time Complexity: O(decodeString length)
//Space Complexity:O(n)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt=new Stack<>();
        Stack<StringBuilder> strSt=new Stack<>();
        StringBuilder curr=new StringBuilder();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }else if(c=='['){
                numSt.push(num);
                strSt.push(curr);
                num=0;
                curr=new StringBuilder();
            }
            else if(c==']'){
                //Decipher the string
                int k=numSt.pop();
                StringBuilder child=new StringBuilder();
                for(int j=0;j<k;j++){
                    child.append(curr);
                }
                //Combine with parent
                StringBuilder parent=strSt.pop();
                curr=parent.append(child);
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
