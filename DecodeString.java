// Time Complexity : O(max(k,n)), k= product of all numbers, n = length of given string
// Space Complexity : O(max(k,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS

class DecodeString {
  public String decodeString(String s) {
      Stack<Integer> stk2=new Stack<>();
      Stack<StringBuilder> stk1=new Stack<>();
      int currnum=0;
      StringBuilder currstr=new StringBuilder();
      for(int i=0;i<s.length();i++){
          char ch=s.charAt(i);
          if(Character.isDigit(ch)){
              currnum=currnum*10+ (ch-'0');
          }else if(ch=='['){
              stk2.push(currnum);
              stk1.push(currstr);
              currstr=new StringBuilder();
              currnum=0;
          }else if(ch==']'){
              int times=stk2.pop();
              StringBuilder baby=new StringBuilder();
              while(times>0){
                  baby.append(currstr);
                  times--;
              }
              StringBuilder parent=stk1.pop();
              currstr=parent.append(baby);
          }else{
              currstr.append(ch);
          }
      }
      return currstr.toString();
  }
}
/*

//DFS
class DecodeString {
  int i=0;
  public String decodeString(String s) {
      int currnum=0;
      StringBuilder currstr=new StringBuilder();
      while(i<s.length()){
          char ch=s.charAt(i);
              if(Character.isDigit(ch)){
                  currnum=currnum*10+ (ch-'0');
                  i++;
              }else if(ch=='['){
                  i++;
                  String decoded = decodeString(s);
                  StringBuilder baby=new StringBuilder();
                  while(currnum>0){
                      baby.append(decoded);
                      currnum--;
                  }
                  currstr=currstr.append(baby);
              }else if(ch==']'){
                  i++;
                  return currstr.toString();
              }else{
                  currstr.append(ch);
                  i++;
              }
      }
      return currstr.toString();
  }
}
*/