// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/decode-string/description/
// Any problem you faced while coding this : No


class Solution {
    public String decodeString(String s) {
        if(s.length()==0) return "";
Stack<Integer> counts = new Stack<>();
Stack<String> input = new Stack<>();
String result = "";
int index = 0;
while(index<s.length()){
if(Character.isDigit(s.charAt(index))){
int count = 0;
while(Character.isDigit(s.charAt(index))){
count = 10*count + (s.charAt(index) - '0');
index+=1;
}counts.push(count);
}
if(s.charAt(index)=='['){
input.push(result);
result="";
index+=1;
}
                      else if(s.charAt(index)==']'){
StringBuilder temp = new StringBuilder(input.pop());
int count = counts.pop();
for(int i=0;i<count;i++){
temp.append(result);
}
result = temp.toString();
index++;
}
                      else{
result +=s.charAt(index);
index++;
}
}
return result.toString();
    }
}
