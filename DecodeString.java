//DFS - using Stack
//Time Complexity - O(Maxk * N) - where N is length of string and K is the maximum of the repeat number
//Space Complexity - O( M + N) - where M is the no of letters & N is the number of digits
class Solution {
  public String decodeString(String s) {


    if(s == null || s.length() == 0){
      return s;
    }

    Stack<String> letterStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();

    int num = 0;
    String currString = "";

    for(int i=0; i<s.length(); i++){

      char character = s.charAt(i);

      if(Character.isDigit(character)){
        num = num*10 + character-'0';
      }
      else if(character == '['){
        numStack.add(num);
        letterStack.add(currString);

        num = 0;
        currString = "";
      }
      else if(character == ']'){
        int times = numStack.pop();
        StringBuilder sb = new StringBuilder();

        for(int j=0; j<times; j++){
          sb.append(currString);
        }
        currString = letterStack.pop()+ sb.toString();
      }
      else{
        currString = currString+character;
      }
    }
    return currString;
  }
}